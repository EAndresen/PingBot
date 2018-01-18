package codes.andresen;

import java.io.IOException;

class CalculatePing {
    private Pinger pinger = new Pinger();

    void calculatePing(int inputEndOfEndIP,
                       int infinityPings,
                       String inputStartIP,
                       String countInput,
                       String size) {

        int pos = inputStartIP.lastIndexOf(".");
        int endOfFirstIP = Integer.parseInt(inputStartIP.substring(pos+1, inputStartIP.length()));
        String beginningOfFirstIP = inputStartIP.substring(0, pos);
        int numberOfPings = inputEndOfEndIP - endOfFirstIP +1;

        for(int i = 0; i < numberOfPings; i++){
            String ip = beginningOfFirstIP + "." + Integer.toString(endOfFirstIP);
            String count;

            if(infinityPings == -1){
                count = "-1";
            }else {
                count = countInput;
            }
            try {
                pinger.ping(ip, count, size);
            } catch (IOException e) {
                e.printStackTrace();
            }
            endOfFirstIP++;
        }
    }
}
