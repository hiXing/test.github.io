
webview��js������Ҫ���
	``` webview.getSetting().setJavaScriptEnable(true);```
�������ã�
	``` webView.addJavascriptInterface(new Object(), "call");```
	

* html����java���� 
	����1��`` E/Web Console: Uncaught TypeError: Object [object Object] has no method 'toString' ``
	
	��Android4.2�Ժ�İ汾��Ҫ�ڵ��õķ���ǰ��ע����� ``  @JavascriptInterface ``
	
	```
		class Object {  
			@JavascriptInterface  
			public String toString() { return "callObject"; }			
		}  
	```
	
	����2��`` E/Web Console(19235): Uncaught Error: Error calling method on NPObject. at http://192.168.1.11/mobile/..........js:428 ``
	
	�����Android�̰߳�ȫ������,�������߳̽��в���,���Ǵ���ĳ���������������ͽ����:
	
	```
		new Thread(new Runnable(){
			@Override
			public void run(){
				//code
			}
		
		}).start();
		
		//����
		Handler handler = new Handler();
		handler.post(new Runnable(){
			@Override
			public void run(){
				//code
			}
		});
	```


* JAVA��JS����ע������

	1��Java ���� js ����ĺ�����Ч�ʲ����Ǻܸߡ�����Ҫ200ms���Ұɡ��������Ժ�ǿ�����顢�����ٶȺ������˽��ܡ�
	��jsȥ��Java�ķ������ٶȺܿ졢50ms���ҡ����Ծ�����js����Java����
	2��Java ���� js �ĺ�����û�з���ֵ�������˾Ϳ��Ʋ�����
	3��Js ���� Java �ķ���������ֵ������ַ�������ᷢ������ַ����� native �ġ�ת�� locale �Ĳ�������ʹ�á�ʹ�� toLocaleString() �����Ϳ����ˡ���������������ٶȲ����졢ת�����ַ�������ܶࡢ����ܺķ�ʱ��
	4����ҳ�о�����Ҫʹ��jQuery��ִ��������Ҫ5-6�롢���ʹ��ԭ����jsдҵ��ű��������������ٶȡ������û�����	

	
�ο�ʵ�����ӣ�http://blog.csdn.net/ithomer/article/details/8737999