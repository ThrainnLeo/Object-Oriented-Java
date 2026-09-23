package logic;
import java.util.Arrays;

public class Rod {
    private final Disk[] diskArr;
    private int n;

    public Rod(int capacity){
        //Att kolla för negativa tal
        this.diskArr = new Disk[capacity];
        this.n = 0;
    }

    public Rod() {
        this(3);
    }

    public int getNumberOfDisks(){
        return n;
    }

    public int getMaxNumberOfDisks(){
        return diskArr.length;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public Disk peek(){
        if(isEmpty()){
            return null;
        }
        return diskArr[n - 1];
    }

    public boolean canPush (Disk nDisk){
        if(isEmpty()) return true;
        Disk top = diskArr[n - 1];
        return nDisk.diameter() < top.diameter();
    }

    public void push(Disk disk){
        if(!canPush(disk)) throw new IllegalArgumentException("Disk out of bounds");
        diskArr[n] = disk;
        n++;
    }

    public Disk pop(){
        n--;
        Disk temp = diskArr[n];
        diskArr[n] = null;
        return temp;
    }

    public Disk[] copyDiskArr(){
        Disk[] temp = new Disk[n];
        System.arraycopy(diskArr, 0, temp, 0, n);
        return temp;
    }

    public void clear() {
        for(int i = 0; i < diskArr.length; i++){
            diskArr[i] = null;
        }
        n = 0;
    }

    @Override
    public String toString() {
        return "Rod{" +
                " " + Arrays.toString(diskArr) +
                ", " + n +
                '}';
    }
}
