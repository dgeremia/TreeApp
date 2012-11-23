/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeApp;

import java.util.Scanner;

/**
 *
 * @author Diego Geremia
 * 
 */
public class Tree {
    public TreeNode root;    
    
    public Tree(String input){
        inOrderExpression = "";
        postOrderExpression = "";  
        root = null;
        
        Scanner scanner = new Scanner(input);
        root = build(scanner);
        inOrder(root);
        postOrder(root);
    }
    
    private TreeNode build ( Scanner input ) {
      boolean  leaf;
      String   token;
      String   value;
      TreeNode node;
      
      leaf = input.hasNextInt();
      if ( leaf ) {
         value = String.valueOf(input.nextInt());         
         node = new TreeNode ( leaf, value );         
      }
      else {
         token = input.next();         
         node  = new TreeNode ( leaf, token );         
         node.izq = build ( input );
         node.der = build ( input );         
      }
      return node;
   }
    
    
    
    private String postOrderExpression;
    public String getPostExpression(){ return postOrderExpression.trim(); }
    private String inOrderExpression;
    public String getInExpression(){ return inOrderExpression.trim(); }
    
    public void postOrder(TreeNode a){
        if (a != null) {
            postOrder(a.izq);
            postOrder(a.der);
            postOrderExpression += (a.value + " ");
        }
    }

    public void inOrder(TreeNode a){
        if (a != null) {
            inOrder(a.izq);
            inOrderExpression += (a.value + " ");
            inOrder(a.der);
        }
    }            
    
    public class TreeNode{
        public TreeNode izq;
        public TreeNode der;
        public String value;
        public final boolean leaf;
        
        public TreeNode(boolean leaf, String value){
            this.leaf = leaf;
            this.value = value;
        }
        
        @Override
        public String toString(){
            return value;  
        }
    }
    
}
