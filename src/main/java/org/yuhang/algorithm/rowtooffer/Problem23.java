package org.yuhang.algorithm.rowtooffer;

/**
 * 判断数组是不是二叉搜索树后序遍历结果
 * Created by chinalife on 2018/5/14.
 */
public class Problem23 {

    /**
     * 最后一位是根节点，比根节点小的是左子树，比根节点大的是右子树，
     * 然后递归判断左右子树是否满足二叉搜索树的后序遍历结果
     *
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        if (sequence.length == 1)
            return true;
        int length = sequence.length;
        int rootNum = sequence[length - 1];
        int flag = -1;
        //找出左右子树
        for (int i = 0; i < length - 1; i++) {
            if (sequence[i] < rootNum) {
                flag = i;
            }
        }
        int[] leftsquence;
        if (flag == -1) {
            leftsquence = null;
        } else {
            leftsquence = new int[flag + 1];

            for (int i = 0; i < leftsquence.length; i++) {
                leftsquence[i] = sequence[i];
                if (leftsquence[i] > rootNum)
                    return false;
            }
        }

        int[] rightsquence = new int[length - 1 - flag - 1];
        int j =0;
        for (int i = flag + 1; i < rightsquence.length; i++) {
            rightsquence[j] = sequence[i];
            if (rightsquence[j] < rootNum)
                return false;
            j++;
        }
        //递归调用
        if (leftsquence == null)
            return VerifySquenceOfBST(rightsquence);
        if(rightsquence.length==0)
            return VerifySquenceOfBST(leftsquence);
        return VerifySquenceOfBST(leftsquence) && VerifySquenceOfBST(rightsquence);

    }

    public static void main(String[] args) {
        Problem23 p = new Problem23();
        int[] s = {1,2,3,4,5};
        System.out.println(p.VerifySquenceOfBST(s));
    }

}
