package chessgame;

public class Position {

	int x;
	int y;

	
	/**
	 * a1이라고 입력된 좌표를 0, 0으로 변환 해주는 메소드 
	 * @param xAndY(ex : "a3")
	 */
	public void transfer(String xAndY) {
		this.x = xAndY.charAt(0) - "a".charAt(0); // 문자를 숫자로 바꾼 후 a를 빼면 0~7숫자가 나옴 
		this.y = Integer.parseInt(xAndY.substring(1))-1;// -1은 컴퓨터에서 0부터 index를 시작해서 
	}

}
