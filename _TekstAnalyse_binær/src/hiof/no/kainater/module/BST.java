package hiof.no.kainater.module;

public class BST {

    TreNode root;

    public BST() {
        root = null;    // Assign the root value to 0 , in BinarySearchTree
    }

   public void insert (String word){   // create a insert methode
     root = insert(root,word);
    }

    // how insert function works when
    private TreNode insert(TreNode subTre, String word){
       if (subTre == null){
           subTre = new TreNode(word);
       } else if (word.compareTo(subTre.getWord()) < 0){  // if less then the current value in the sub three, go left ( by mid)
           subTre.set_LeftChild( insert(subTre.get_LeftChild(),word)); // and insert
       } else if (word.compareTo(subTre.getWord()) == 0){
           subTre._counter(); // increases in counter
       } else {
           subTre.set_RightChild(insert(subTre.get_RightChild(),word)); // if higher go to right side of subtree.
       }

        return subTre;
    }

/**
 * Inorder traverse ( depth-first):
 * vistit first (or process the data in the nodes) <left> < root > < right>
 *     visit first left subtree
 *     visit root ( of addres kinda pointer in C, like memomry)
 *     visit right subtree.
 */

public void _InOrder() {
               _InOrder(root);
           }


    private void _InOrder(TreNode subTre){
            if (subTre == null){
                return;
            }

            _InOrder(subTre.get_LeftChild());
             System.out.println(subTre);
           _InOrder(subTre.get_RightChild());

     }




}
