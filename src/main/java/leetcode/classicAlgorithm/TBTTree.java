package leetcode.classicAlgorithm;

import com.alibaba.fastjson.JSON;

/**
 * 建立中虚遍历线索树
 */
public class TBTTree {

    private TBTNode pre;

    private static class TBTNode<T>{
        T data;
        int ltag , rtag;
        TBTNode<T> lchild,rchild;

        public TBTNode(T data) {
            this.data = data;
        }

        public TBTNode() {
        }
    }


    void Thread(TBTNode p){
        if(p != null){
            Thread(p.lchild);

            if(p.lchild == null){
                p.lchild = pre;
                p.ltag = 1;
            }else{
                p.ltag = 0;
            }

            if(pre.rchild == null){
                pre.rchild = p;
                pre.rtag = 1;
            }else{
                pre.rtag = 0;
            }
            pre = p;
            Thread(p.rchild);
        }
    }

    TBTNode createThread(TBTNode b){
        TBTNode root = new TBTNode();
        root.ltag = 0 ;
        root.rtag = 1;
        root.rchild = root;
        if(b == null){
            root.lchild = root;
        }else{
            root.lchild = b;
            pre = root;
            Thread(b);
            pre.rchild = root;
            pre.rtag = 1;
            root.rchild = pre;
        }
        return root;
    }

    public static void main(String[] args){
        TBTNode<Integer> node = new TBTNode<>(1);
        TBTNode<Integer> node1 = new TBTNode<>(2);
        TBTNode<Integer> node2 = new TBTNode<>(3);
        TBTNode<Integer> node3 = new TBTNode<>(4);

        node.lchild = node1;
        node1.lchild = node2;
        node2.rchild = node3;

        System.out.println(JSON.toJSONString(new TBTTree().createThread(node)));
    }
}
