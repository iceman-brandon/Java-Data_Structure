package Section2;

/* [2차원 배열에서 소수 찾기]
 * 입력으로 n*n개의 음이 아닌 한자리 정수가 그림과 같이 주어진다.(Code21.png 참고)
 * 이 정수들 중 가로, 세로, 대각선의 8방향으로 연속된 숫자들을 합쳐서 만들 수 있는 모든
 * 소수를 찾아서 나열하는 프로그램을 작성하라. 중복된 수를 출력해도 상관없다.
 * 
 * (컴퓨터는 빠르다. 뭔가 교묘한 방법을 찾으려 하지 말고, 무식하지만 논리적으로
 *  가장 명료한 방법을 먼저 찾아라. 그런 다음 어떻게 개선할 수 있는지를 고민하라.)
 *  
 * [명료하고 단순하게...]
 * 모든 가능한 수열들에 대해서 정수값으로 환산하라;
 * 만약 그것이 소수이면 출력한다; (Code21(2).png 참고)
 * 
 * [모든 가능한 수열들에 대해서]
 * - 하나의 수열은 (시작점, 방향, 길이)에 의해서 정의된다.
 * - 방향은 0~7번까지의 수로 표현하자.
 * (임의의 시작점(x,y)에 대해서 (최대) 8가지 방향이 있음. (각 방향을 0~7번 방향이라고 부르자)
 * 
 * ... 중략 ... (이미지들 참고하기)
 * 
 * (프로그램 전체를 한 자리에서 다 해결하려고 하지 말고, 적절한 순간에 적절한 함수들을 만들어서
 * 세부적인 고민들은 그 함수를 작성하면서 하고...)
 */
public class Code21 {
	public static void main(String[] args) {
		// 실제 구현은 다음에 직접 해보기..
		/* 
		 * 그러나, 설명했던게 최선의 해결방법은 아니다. 
		 * 조금만 살펴보면 엄청난 많은 계산의 중복, 비효율성들이 숨어있다.
		 * 하지만 이제 그런걸 어떻게 찾아서 어떻게 중복을 없애고 어떻게 더 효율적으로 할거냐
		 * 이건 지금 우리가 얘기할 주제가 아니고...
		 * 지금 우리가 습득해야하는건 이런 문제가 주어졌을 때 이것을 논리적으로 가장 간명한 방법을
		 * 쉽게 떠올리는... 그게 지금 우리가 해야될 일이다.
		 * 어떤 문제를 논리적으로 가장 단순하고, 어떻게 보면 좀 무식하지만, 
		 * 대신 너무나 간명하기 때문에 실수를 할래야 실수를 하기가 어려울 정도로
		 * 논리적으로 간명한 방법을 떠올리는 것, 그게 되어야 그 다음 스텝으로 넘어가서 더 좋은 알고리즘, 더 좋은 방법을 찾는게 가능하지
		 * 그게 안되는 사람이 어떻게 해가지고 좋은 방법을 찾아낸다. 이런건 현실적으로 가능하지 않다.
		 */
	}
}