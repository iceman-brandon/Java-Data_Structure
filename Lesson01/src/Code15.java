import java.util.Scanner;

// 오름차순 정렬
/*
 * 사용자로부터 n개의 정수를 입력받는다.
 * 정수가 하나씩 입력될 때마다 현재까지 입력된 정수들을
 * 오름차순으로 정렬하여 출력하라.
 * ================================================================================================================================================
 * 예를 들어, 1, 3, 4, 6, 7, 9 순으로 이미 정렬된 상태로 배열에 저장되어있는데,
 * 새로운 값 5가 이번에 입력이 됐다. 그럼 이 5를 어떻게 할거냐?
 * (이 5를 마지막 자리에 저장한 후에 이 데이터 전체를 버블정렬해버리면 정렬이 되긴 하겠지만, 불필요하게 많은 일을 한다.
 *  그런 버블정렬보다 더 효율적이고 쉬운 정렬 알고리즘을 짤 수 있다.)
 * 5를 제외한 나머지 정수들은 이미 정렬이 되어있기 때문에, 순서를 손 볼 이유가 전혀 없다.
 * 다만, 새로 입력된 정수 5를 자기 자리에(4와 6 사이에) 끼워 넣기만 하면 되니까 훨씬 더 간단하게 할 수 있다는 것이다.
 * 
 * 이 5를 내가 어디에 끼워넣어야 되는지를 어떻게 알아낼거냐? 기본적으로 2가지 방법을 생각할 수 있다.
 * ① 앞에서부터 이 수들을 쭉 검사해보는 것이다. 즉, 앞에서부터 이 수들을 5와 비교해본다.
 *    그래서, 처음으로 5보다 크거나 같은 애가 나타나면, 걔 바로 앞에 5를 넣는다.
 *    
 * ② 뒤에서부터 검사해서(9, 7, 6 이렇게 검사해서) 처음으로 5보다 작거나 같은애가 나타나면,
 *    얘 뒤에 5를 넣어야겠구나. 이렇게 판단할 수 있다.
 * 즉, 앞에서 쭉 검사해서 5보다 큰 애가 나타날 때까지 혹은 뒤에서부터 검사해서 5보다 작은 애가 나타날 때까지 검사한다면
 * 5가 어디에 들어가야 할지를 알 수가 있는 것이다.
 * 
 * 이 2가지 방법은 대칭적이기 때문에 그게 그거라고 똑같은 것처럼 생각할 수 있지만, 사실은 조금 차이가 있다.
 * ①번 방법대로 앞에서부터 검사를 하게 되면 5가 들어갈 자리를 찾기 위해서 우리가 1, 3, 4, 6을 한번 씩 봐야된다.
 * 그런데, 문제는 이 자리에 내가 5를 끼워넣으려면(배열에서 중간에 어떤 값을 끼워넣으려면) 이 뒤에 있는 값들을 1칸 씩 뒤로 옮기는 수 밖에 없다.
 * 그러니까, 6, 7, 9를 다 1칸 씩 뒤로 옮겨야된다. 결과적으로는, 5가 들어갈 자리를 찾기 위해서 5보다 작은 값들을 다 한번씩 봐야하고,
 * 또 실제로 이 자리에 5를 넣기 위해서 5보다 큰 값들은 다 한칸 씩 뒤로 이동시켜야하니까 항상 이 모든 값을 다 보거나 건드려야되는 것이다.
 * 
 * 반면에, ②번 방법대로 뒤에서부터 검사를 하게 되면, 처음에 9를 볼 때 9는 5보다 크니까 어차피 9는 뒤로 1칸 가야한다는 생각을 할 수 있다.
 * 5가 어디에 들어갈지는 아직은 모르지만, 어쨌거나 9보다는 앞쪽에 들어가야하는건 분명하니까 9는 어차피 1칸 뒤로 가야한다.
 * 그래서, 9를 1칸 뒤로 보내고, 그 다음에 7을 보면, 7도 5보다 크니까 어차피 1칸 뒤로 가야된다.
 * 7을 그냥 9가 있던 자리에 쓴다.(9는 이미 1칸 뒤로 갔으니까 문제 없다)
 * 그 다음은 6도 5보다 크니까 뒤로 보낸다. 그 다음에 4를 볼 차례다. 4를 봤더니 드디어 5보다 작은 애가 나타났다!
 * 그러면 그 바로 뒷 자리에 내가 5를 넣어주면 된다는 것이다.
 * 이렇게 하면, 원래 배열에 들어있는 값이 지워지는 것에 대해서 걱정할 필요가 없고, 앞쪽에 남아있는 수도 볼 필요가 없어진다.
 * 따라서 넣어주고 바로 stop하면 된다.
 * 그 얘기는 평균적으로는 한 절반 정도의 데이터만 보면 된다.(물론 최악의 경우에는 그렇지 않을 수 있겠지만)
 * 
 *  그래서 보통 이런식으로 하는 걸 어떤 데이터를 ordered list(순서화된 리스트, 값들이 크기 순으로 정렬되있는 리스트)에
 *  새로운 값을 끼워넣는 알고리즘이다.
 */
public class Code15 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] data = new int[n];
		
		for (int i=0; i<n; i++) {
			// 새로 입력된 값을 무작정 처음부터 배열에 넣어주는게 아니라
			int tmp = sc.nextInt(); // 임시로 이 값을 가지고 있으면서 이 값을 어디에 넣는지 찾아야하니까...
			
			int j = i-1; // j = 현재 입력된 맨 마지막 데이터의 인덱스
			while (j>=0 && data[j] > tmp) { // data[j]가 이번에 새로 입력된 데이터 tmp보다 큰 동안 그리고, j가 0보다 크거나 같은 동안에만 while문을 돌도록
											// (tmp보다 작거나 같은 애가 나타날 때까지)
				data[j+1] = data[j]; // 그동안 data[j]를 한칸 씩 뒤로 보낸다.(data[j]를 data[j+1]자리로 보낸다)
				j--;
			}
			data[j+1] = tmp; // tmp보다 작거나 같은 애의 뒷 자리에 tmp값을 넣는다.
							 // (j가 음수가 되서 빠져나오면(j가 -1이 되면) 
						     // j+1은 data[0]이 되니까 그 경우에는 맨 첫번째 자리에 tmp를 저장하게됨)
			// 출력
			for (int k=0; k<=i; k++) // 데이터가 하나 더 들어갔으니까 i+1개임. 그러니까, 인덱스는 0에서 i까지 돌아야함
				System.out.print(data[k] + " "); // 줄 바꾸지 않고 i+1개의 데이터 정수들을 한칸 씩 띄워서 출력
			System.out.println(); // 그리고, 줄바꿈
		}
		sc.close();
	}
}