package com.yc.recursion;

public class MiGong {
	public static void main(String[] args) {
		//先创建一个二维数组，模拟迷宫
		//地图
		int[][] map = new int[8][7];
		//使用1表示墙
		//上下全部置为1
		for(int i=0; i<8; i++){
			map[i][0] = 1;
			map[i][6] = 1;
		}
		for(int j=0; j<7; j++){
			map[0][j] = 1;
			map[7][j] = 1;
		}
//		//输出
//		for(int i=0; i<map.length; i++){
//			for(int j=0; j<map[i].length; j++){
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		map[3][1] = 1;
		map[3][2] = 1;
		map[2][2] = 1;
		map[1][2] = 1;
		//使用递归回溯给小球找路
		setWay(map, 1, 1);
		//输出
		for(int i=0; i<map.length; i++){
			for(int j=0; j<map[i].length; j++){
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean setWay(int[][] map, int i, int j) {
		if(map[6][5] == 2){//通路已经找到ok
			return true;
		}else{
			if(map[i][j] == 0){
				//如果当前这个点还没有走过
				//选择策略：下->右->上->左
				map[i][j] = 2;
				if(setWay(map, i+1, j)){
					return true;
				}else if(setWay(map, i, j+1)){
					return true;
				}else if(setWay(map, i-1, j)){
					return true;
				}else if(setWay(map, i, j-1)){
					return true;
				}else{
					//说明该点走不通
					map[i][j] = 3;
					return false;
				}
			}else{
				//如果map[i][j]!=0，可能是1,2,3
				return false;
			}
		}	
	}
}
