public class OneDayThree {

  public static void main(String[] args) {

    System.out.println(new OneDayThree().findShortPath(289326));
  }

  public int findShortPath(int input) {
    Ring containingRing = Ring.findContainingRing(input);
    return newCalcPath(containingRing, input);
  }

  /* 4 4 4 4 4 4 4
     4 3 3 3 3 3 4
     4 3 2 2 2 3 4
     4 3 2 1 x 3 4
     4 3 2 2 2 x 4
     4 3 3 3 3 3 x
     4 4 4 4 4 4 4
   */

  int newCalcPath(Ring containingRing, int input) {
    int ringContents = containingRing.ringMaximum - containingRing.innerMax;
    int divisor = ringContents / 4;

    int corner1 = containingRing.innerMax + divisor;
    int corner2 = corner1 + divisor;
    int corner3 = corner2 + divisor;
    int corner4 = corner3 + divisor;
    assert (corner4 == containingRing.ringMaximum);

    // find side
    int highCorner = 0;
    if(input < corner1) {
      highCorner = corner1;
    }else if(input < corner2) {
      highCorner = corner2;
    } else if(input < corner3) {
      highCorner = corner3;
    } else {
      highCorner = corner4;
    }

    int middle = highCorner - (divisor / 2) ;
    int stepsToMiddle = Math.abs(input - middle);

    return containingRing.ringNumber + stepsToMiddle -1;



  }

  int calcThePath(Ring containingRing, int input) {
    int ringContents = containingRing.ringMaximum - containingRing.innerMax;
    int correctedInput = input - containingRing.innerMax;

    int divisor = ringContents / 4;
    int leftCorner = 0;
    int rightCorner = ringContents;
    for (int i = 4; i > 0; i--) {
      leftCorner = rightCorner - divisor;
      if (correctedInput > leftCorner) {
        int middlePosition = (divisor / 2) + leftCorner;
        int stepsToMiddle = Math.abs(correctedInput - middlePosition);
        return stepsToMiddle + containingRing.ringNumber - 1;
      } else {
        rightCorner = leftCorner;
      }
    }
    return -1;
  }

}

class Ring {
  public int ringNumber;
  public int ringMaximum;
  public int innerMax;

  Ring(int num, int max, int prevMax) {
    ringNumber = num;
    ringMaximum = max;
    innerMax = prevMax;
  }

  static Ring findContainingRing(int input) {
    int ringNum = 2;
    int ringMax = 9;
    int innerMax = 0;
    int edge = 3;

    while (ringMax < input) {
//      ringNum++;
//      innerMax = ringMax;
//      ringMax = ringMax * 2 + 7;

      ringNum++;
      int newEdge = edge+2;
      innerMax = ringMax;
      ringMax = innerMax + (newEdge-1)*4 ;
      edge = newEdge;
    }
    return new Ring(ringNum, ringMax, innerMax);
  }
}
