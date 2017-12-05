public class TwoDayOne {


    public static void main(String[] args) {

        int result = 0;
        final String input = args[0];
        TwoDayOne worker = new TwoDayOne(input);
        int distance = input.length() / 2;

        System.out.println("Input_string_lenght: " + input.length()+
        "distance between : " + distance);

        for (int i = 0; i < input.length(); i++) {
            if (worker.getNextInt(i) == worker.getNextInt(i + distance)) {
                result += worker.getNextInt(i);
            }
        }
        System.out.println("Result: " + result);
    }

    int[] inputInts;
    String inputString;

    TwoDayOne(String inputString) {
        this.inputString = inputString;
        inputInts = new int[inputString.length()];
    }

    int getNextInt(int index) {
        int indexMod = index % inputInts.length;

        if (inputInts[indexMod] == 0) {
            inputInts[indexMod] = Integer.parseInt(inputString.substring(indexMod, indexMod + 1));
            System.out.println("inputInts[" + indexMod + "] = " + inputInts[indexMod]);
        }
        return inputInts[indexMod];
    }
}


