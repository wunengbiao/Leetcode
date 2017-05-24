package Tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by wunengbiao on 2017/3/29.
 */
public class Codec_2 {
    private static final String spliter=",";
    private static final String NN="#";
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        buildString(root,sb);
        return sb.toString();
    }

    public void buildString(TreeNode root,StringBuilder sb){
        if(root==null)
            sb.append(NN).append(spliter);
        else{
            sb.append(root.val).append(spliter);
            buildString(root.left,sb);
            buildString(root.right,sb);
        }
    }

    public TreeNode deserialize(String data) {
        Deque<String> nodes=new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes){
        String val=nodes.remove();
        if(val.equals(NN)) return null;
        else{
            TreeNode node=new TreeNode(Integer.parseInt(val));
            node.left=buildTree(nodes);
            node.right=buildTree(nodes);
            return node;
        }
    }

    public static void main(String[] args){
        Codec_2 codec=new Codec_2();
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);

        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;

        String res=codec.serialize(node1);
        System.out.println(res);

        Deque<Integer> queue=new LinkedList<>();
        queue.addAll(Arrays.asList(1,2,3,4,5));
        queue.remove();
        System.out.println(queue);

//        System.out.println(codec.deserialize(res));

    }
}
