package codes.andresen;

class CreatePingString {
    String createPingLine(String countInput, String sizeInput, String ipInput) {
        if (countInput.equals("-1")){
            countInput = "-t ";
        } else {
            countInput = "-n " + countInput;
        }
        return "ping " + countInput + " -l " + sizeInput + " " + ipInput;
    }
}
