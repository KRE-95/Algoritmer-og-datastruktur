package hiof.no.kainater.module;

public class TreNode {
    private String word;
    private int counter;
    private TreNode _LeftChild, _RightChild;


    public TreNode(String word){
        this.word = word;
        counter = 1; // instance by 1
        _LeftChild = _RightChild = null; // height of a subtree with one node is 0

    }

    // make methode for counter
    public void _counter(){
        counter++;
    }



    // get and set :


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public TreNode get_LeftChild() {
        return _LeftChild;
    }

    public void set_LeftChild(TreNode _LeftChild) {
        this._LeftChild = _LeftChild;
    }

    public TreNode get_RightChild() {
        return _RightChild;
    }

    public void set_RightChild(TreNode _RightChild) {
        this._RightChild = _RightChild;
    }

    @Override
    public String toString() {
        return "  " + " Ordet forekom : " + word + " - " + counter + " gang(er).";
    }
}
