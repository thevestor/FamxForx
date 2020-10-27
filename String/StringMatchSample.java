package String;

/**
 * �ַ���ƥ��Sample
 * <p>
 * ƥ���㷨:<br>
 * 1. ����ƥ��<br>
 * 2. <a href="http://blog.csdn.net/v_july_v/article/details/7041827">KMPƥ�� </a>
 * </br>
 * 3. �Ľ�KMPƥ��<br>
 * 
 * @author Tianma
 *
 */
public class StringMatchSample {

	private interface StringMatcher {
		/**
		 * ��ԭ�ַ����в���ģʽ�ַ�����λ��,���ģʽ�ַ�������,�򷵻�ģʽ�ַ�����һ�γ��ֵ�λ��,���򷵻�-1
		 * 
		 * @param source
		 *            ԭ�ַ���
		 * @param pattern
		 *            ģʽ�ַ���
		 * @return if substring exists, return the first occurrence of pattern
		 *         substring, return -1 if not.
		 */
		int indexOf(String source, String pattern);
	}

	/**
	 * ����ƥ��
	 * <p>
	 * ʱ�临�Ӷ�: O(m*n), m = pattern.length, n = source.length
	 */
	static class ViolentStringMatcher implements StringMatcher {

		@Override
		public int indexOf(String source, String pattern) {
			int i = 0, j = 0;
			int sLen = source.length(), pLen = pattern.length();
			char[] src = source.toCharArray();
			char[] ptn = pattern.toCharArray();
			while (i < sLen && j < pLen) {
				if (src[i] == ptn[j]) {
					// �����ǰ�ַ�ƥ��ɹ�,�����߸�����1,�����ȽϺ�����ַ�
					i++;
					j++;
				} else {
					// �����ǰ�ַ�ƥ�䲻�ɹ�,��i���ݵ��˴�ƥ���ʼ��λ��+1��,Ҳ����i = i - j + 1
					// (��Ϊi,j��ͬ��������), j = 0;
					i = i - j + 1;
					j = 0;
				}
			}
			// ƥ��ɹ�,�򷵻�ģʽ�ַ�����ԭ�ַ������״γ��ֵ�λ��;���򷵻�-1
			if (j == pLen)
				return i - j;
			else
				return -1;
		}
	}

	/**
	 * KMPģʽƥ��
	 * 
	 * @author Tianma
	 *
	 */
	static class KMPStringMatcher implements StringMatcher {

		/**
		 * ��ȡKMP�㷨��pattern�ַ�����Ӧ��next����
		 * 
		 * @param p
		 *            ģʽ�ַ�����Ӧ���ַ�����
		 * @return
		 */
		protected int[] getNext(char[] p) {
			// ��֪next[j] = k,���õݹ��˼�����next[j+1]��ֵ
			// �����֪next[j] = k,������next[j+1]��?�����㷨����:
			// 1. ���p[j] = p[k], ��next[j+1] = next[k] + 1;
			// 2. ���p[j] != p[k], ����k=next[k],�����ʱp[j]==p[k],��next[j+1]=k+1,
			// ��������,������ݹ�ǰ׺����,�� k=next[k],�����ж�,ֱ��k=-1(��k=next[0])����p[j]=p[k]Ϊֹ
			int pLen = p.length;
			int[] next = new int[pLen];
			int k = -1;
			int j = 0;
			next[0] = -1; // next������next[0]Ϊ-1
			while (j < pLen - 1) {
				if (k == -1 || p[j] == p[k]) {
					k++;
					j++;
					next[j] = k;
				} else {
					k = next[k];
				}
			}
			return next;
		}

		@Override
		public int indexOf(String source, String pattern) {
			int i = 0, j = 0;
			char[] src = source.toCharArray();
			char[] ptn = pattern.toCharArray();
			int sLen = src.length;
			int pLen = ptn.length;
			int[] next = getNext(ptn);
			while (i < sLen && j < pLen) {
				// ���j = -1,���ߵ�ǰ�ַ�ƥ��ɹ�(src[i] = ptn[j]),����i++,j++
				if (j == -1 || src[i] == ptn[j]) {
					i++;
					j++;
				} else {
					// ���j!=-1�ҵ�ǰ�ַ�ƥ��ʧ��,����i����,j=next[j],����patternģʽ������j-next[j]����λ
					j = next[j];
				}
			}
			if (j == pLen)
				return i - j;
			return -1;
		}
	}

	/**
	 * �Ż���KMP�㷨(��next����Ļ�ȡ�����Ż�)
	 * 
	 * @author Tianma
	 *
	 */
	static class OptimizedKMPStringMatcher extends KMPStringMatcher {

		@Override
		protected int[] getNext(char[] p) {
			// ��֪next[j] = k,���õݹ��˼�����next[j+1]��ֵ
			// �����֪next[j] = k,������next[j+1]��?�����㷨����:
			// 1. ���p[j] = p[k], ��next[j+1] = next[k] + 1;
			// 2. ���p[j] != p[k], ����k=next[k],�����ʱp[j]==p[k],��next[j+1]=k+1,
			// ��������,������ݹ�ǰ׺����,�� k=next[k],�����ж�,ֱ��k=-1(��k=next[0])����p[j]=p[k]Ϊֹ
			int pLen = p.length;
			int[] next = new int[pLen];
			int k = -1;
			int j = 0;
			next[0] = -1; // next������next[0]Ϊ-1
			while (j < pLen - 1) {
				if (k == -1 || p[j] == p[k]) {
					k++;
					j++;
					// �޸�next������
					if (p[j] != p[k]) {
						next[j] = k;// KMPStringMatcher��ֻ����һ��
					} else {
						// ���ܳ���p[j] = p[next[j]],������������������������ݹ�,�� k = next[k],
						// k = next[[next[k]]
						next[j] = next[k];
					}
				} else {
					k = next[k];
				}
			}
			return next;
		}

	}

	public static void main(String[] args) {
		StringMatcher matcher = new ViolentStringMatcher();
		System.out.println(matcher.indexOf("helloworld", "ow"));
		matcher = new KMPStringMatcher();
		System.out.println(matcher.indexOf("helloworld", "ow"));
		matcher = new OptimizedKMPStringMatcher();
		System.out.println(matcher.indexOf("helloworld", "ow"));
	}

}
