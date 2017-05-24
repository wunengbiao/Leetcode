package Tree;



/**
 * Created by wunengbiao on 2017/3/29.
 */
public class Codec {
    String res="";
    public String serialize(TreeNode root) {
        if(root==null) return res;
       preorder(root);
       return res;
    }

    public void preorder(TreeNode root){
        if(res.length()==0)
            res+=root.val;
        else{
            if(root==null){
                res+=',';
                res+='#';
                return;
            }else{
                res+=',';
                res+=root.val;
            }
        }
        preorder(root.left);
        preorder(root.right);
    }

    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        TreeNode root=new TreeNode(0);
        String[] strs=data.split(",");
        buildTree(root,strs);
        return root;
    }

    int i=0;
    public void buildTree(TreeNode root,String[] strs){
        String value=strs[i++];
        if(value.equals("#")){
            root=null;
            return;
        }
        else{
                root.val=Integer.parseInt(value);
                if(!strs[i].equals("#")){
                    root.left=new TreeNode(0);
                    buildTree(root.left,strs);
                }else{
                    root.left=null;
                    i++;
                }
            if(!strs[i].equals("#")){
                root.right=new TreeNode(0);
                buildTree(root.right,strs);
            }else{
                root.right=null;
                i++;
            }
        }

        }


    public static void main(String[] args){
        Codec codec=new Codec();
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);

        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;

        String res=codec.serialize(null);
        System.out.println(res);

        System.out.println(codec.deserialize(res));

        TreeNode node=new TreeNode(0);
        System.out.println(node);
    }

}
