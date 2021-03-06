import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

public class OneDayTwo {

    public static void main(String[] args) {
        String input = "121\t59\t141\t21\t120\t67\t58\t49\t22\t46\t56\t112\t53\t111\t104\t130\n" +
                "1926\t1910\t760\t2055\t28\t2242\t146\t1485\t163\t976\t1842\t1982\t137\t1387\t162\t789\n" +
                "4088\t258\t2060\t1014\t4420\t177\t4159\t194\t2794\t4673\t4092\t681\t174\t2924\t170\t3548\n" +
                "191\t407\t253\t192\t207\t425\t580\t231\t197\t382\t404\t472\t164\t571\t500\t216\n" +
                "4700\t1161\t168\t5398\t5227\t5119\t252\t2552\t4887\t5060\t1152\t3297\t847\t4525\t220\t262\n" +
                "2417\t992\t1445\t184\t554\t2940\t209\t2574\t2262\t1911\t2923\t204\t2273\t2760\t506\t157\n" +
                "644\t155\t638\t78\t385\t408\t152\t360\t588\t618\t313\t126\t172\t220\t217\t161\n" +
                "227\t1047\t117\t500\t1445\t222\t29\t913\t190\t791\t230\t1281\t1385\t226\t856\t1380\n" +
                "436\t46\t141\t545\t122\t86\t283\t124\t249\t511\t347\t502\t168\t468\t117\t94\n" +
                "2949\t3286\t2492\t2145\t1615\t159\t663\t1158\t154\t939\t166\t2867\t141\t324\t2862\t641\n" +
                "1394\t151\t90\t548\t767\t1572\t150\t913\t141\t1646\t154\t1351\t1506\t1510\t707\t400\n" +
                "646\t178\t1228\t1229\t270\t167\t161\t1134\t193\t1312\t1428\t131\t1457\t719\t1288\t989\n" +
                "1108\t1042\t93\t140\t822\t124\t1037\t1075\t125\t941\t1125\t298\t136\t94\t135\t711\n" +
                "112\t2429\t1987\t2129\t2557\t1827\t477\t100\t78\t634\t352\t1637\t588\t77\t1624\t2500\n" +
                "514\t218\t209\t185\t197\t137\t393\t555\t588\t569\t710\t537\t48\t309\t519\t138\n" +
                "1567\t3246\t4194\t151\t3112\t903\t1575\t134\t150\t4184\t3718\t4077\t180\t4307\t4097\t1705\n";

        int result = Arrays.stream(input.split("\n")).map(s -> otherCheckSumRow(s)).mapToInt(i -> i).sum();
        System.out.println(result);

        int secondResult = Arrays.stream(input.split("\n")).map(s -> secondCheckSumRow(s)).mapToInt(i -> i).sum();
        System.out.println(secondResult);
    }

    private static int secondCheckSumRow(String s) {
        int[] ints = Arrays.stream(s.split("\t")).mapToInt(Integer::parseInt).sorted().toArray();
        for (int outer = 0; outer < ints.length; outer++) {
            for(int inner = ints.length -1; inner > outer; inner--) {
                if (ints[inner] % ints[outer] == 0) {
                    return ints[inner] / ints[outer];
                }
            }
        }

        return 0;
    }

    static int checkSumRow(String inputRow) {
        int min = Integer.MAX_VALUE;
        ;
        int max = 0;
        for (String s : inputRow.split("\t")) {
            int num = Integer.parseInt(s);
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        return max - min;
    }

    static int otherCheckSumRow(String inputRow) {
        IntSummaryStatistics stats = Arrays.stream(inputRow.split("\t"))
                .map(Integer::parseInt)
                .collect(Collectors.summarizingInt(Integer::intValue));
        return stats.getMax() - stats.getMin();
    }
}
