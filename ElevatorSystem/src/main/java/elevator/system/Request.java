package elevator.system;

public class Request {

    int srcFloor;
    int destFloor;

    public int getSrcFloor() {
        return srcFloor;
    }

    public int getDestFloor() {
        return destFloor;
    }

    public Request(int srcFloor, int destFloor) {
        this.srcFloor = srcFloor;
        this.destFloor = destFloor;
    }

    @Override
    public String toString() {
        return "Request{" +
                "srcFloor=" + srcFloor +
                ", destFloor=" + destFloor +
                '}';
    }
}
