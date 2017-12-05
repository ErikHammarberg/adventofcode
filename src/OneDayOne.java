public class OneDayOne {

    public static void main(String[] args) {

        int result = 0;
        final String input = args[0];
        OneDayOne worker = new OneDayOne(input);

        System.out.println("Input_string_lenght: " + input.length());

        for (int i = 0; i < input.length(); i++) {
            if (worker.getNextInt(i) == worker.getNextInt(i + 1)) {
                result += worker.getNextInt(i);
            }
        }
        System.out.println("Result: " +result);
    }

    int[] inputInts;
    String inputString;

    OneDayOne(String inputString) {
        this.inputString = inputString;
        inputInts = new int[inputString.length()];
    }

    int getNextInt(int index) {
        if (index == inputString.length()) {
            return inputInts[0];
        }
        if (inputInts[index] == 0) {
            inputInts[index] = Integer.parseInt(inputString.substring(index, index+1));
            System.out.println("inputInts["+index+"] = "+inputInts[index]);
        }
        return inputInts[index];
    }

}
