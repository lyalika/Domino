package tileanddeck;

public class Tile {
    private int left;
    private int right;

    public Tile(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return this.left;
    }

    public int getRight() {
        return this.right;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public void setRight(int right) {
        this.right = right;
    }

}
