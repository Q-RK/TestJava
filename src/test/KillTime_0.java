package test;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author wangjie
 *题目一：通过键盘输入一串小写字母(a~z)组成的字符串。
 *         请编写一个字符串过滤程序，若字符串中出现多个相同的字符，将非首次出现的字符过滤掉。
 *比如字符串“abacacde”过滤结果为“abcde”。
 *要求实现函数：void stringFilter(const char *pInputStr, long lInputLen, char *pOutputStr);

  【输入】 pInputStr：  输入字符串
              lInputLen：  输入字符串长度        
  【输出】 pOutputStr： 输出字符串，空间已经开辟好，与输入字符串等长； 

  【注意】只需要完成该函数功能算法，中间不需要有任何IO的输入输出

  示例
  输入：“deefd”        输出：“def”
  输入：“afafafaf”     输出：“af”
  输入：“pppppppp”     输出：“p”
 */
public class KillTime_0 {

	/**
	 * 效率低
	 * @param inputStr
	 * @param lInputLen
	 * @param outputStr
	 */
	private static void stringFilter(char[] inputStr,long lInputLen,char[] outputStr){
		Set<Character> charSet = new HashSet<Character>();
		int j = 0;
		for(int i = 0 ; i < inputStr.length ; i++){
			if(charSet.add(inputStr[i])){
				outputStr[j] = inputStr[i];
				j++;
			}
		}
	}
	
	public static void main(String[] args) {
		char[] input = {'a','a'};
		char[] output = new char[2];
		stringFilter(input,2L,output);
		System.out.println();
	}
}
