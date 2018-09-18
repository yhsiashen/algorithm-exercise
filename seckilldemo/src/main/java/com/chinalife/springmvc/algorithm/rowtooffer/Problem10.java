package com.chinalife.springmvc.algorithm.rowtooffer;

/** 矩阵覆盖问题
 * Created by chinalife on 2018/5/3.
 */
public class Problem10 {
    public int RectCover(int target) {
      if( target == 0)
          return 0;
      if( target == 1)
          return 1;
      if( target == 2)
          return 2;
      return RectCover(target-1)+RectCover(target-2);
    }

}
