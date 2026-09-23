package  logic;
import java.util.Random;

public class Tower {
    private Rod left, right, middle;
    private int moves;

    public Tower(int nrOfDisks){
        this.left = new Rod(nrOfDisks);
        this.right = new Rod(nrOfDisks);
        this.middle = new Rod(nrOfDisks);
        this.moves = 0;

        initNewGame();
    }

    public int initNewGame() {
        this.left.clear();
        this.right.clear();
        this.middle.clear();

        this.moves = 0;

        Random random = new Random();
        for (int i = left.getMaxNumberOfDisks(); i > 0; i--) {
            int randomIndex = random.nextInt(Color.values().length);
            left.push(new Disk(Color.values()[randomIndex], i));
        }

        return moves;
    }

    public int getNoOfDisks(){
        return left.getNumberOfDisks() + right.getNumberOfDisks() + middle.getNumberOfDisks();
    }

    public int getMoves(){
        return moves;
    }

    public boolean isLegalMove(RodPos fromPos, RodPos toPos) {
        if (getRod(toPos).peek() == null ) return true;
        if(getRod(fromPos).peek() == null) return false;
        return getRod(toPos).canPush(getRod(fromPos).peek());
    }

    private Rod getRod(RodPos pos) {
        if (pos == RodPos.LEFT) return left;
        else if (pos == RodPos.RIGHT) return right;
        else if (pos == RodPos.MIDDLE) return middle;
        return null;
    }

    public void makeMove(RodPos fromPos, RodPos toPos){
        if(!isLegalMove(fromPos, toPos)) throw new IllegalStateException("Illegal move");

        getRod(toPos).push(getRod(fromPos).pop());
        moves++;
    }

    public boolean isSolved(){
        if(right.getNumberOfDisks() != right.getMaxNumberOfDisks()){
            return false;
        }
        return true;
    }

    public Disk[] getDisks(RodPos pos){
        Rod rod = getRod(pos);
        return rod.copyDiskArr();
    }

    @Override
    public String toString() {
        return "Tower{" +
                "left=" + left +
                ", right=" + right +
                ", middle=" + middle +
                ", moves=" + moves +
                '}';
    }
}
