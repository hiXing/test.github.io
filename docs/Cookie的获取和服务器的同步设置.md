					Cookie�Ļ�ȡ�ͷ�������ͬ������
һ��http��Cookie�Ķ�ȡ�ͷ�����ͬ��
1���������ύsessionId�ͷ�����״̬����һ��
	��AndroidӦ�ó������WEB��������ʱ������Ϊ�������������ͬһ�Ự��Ҳ����˵��ǰ��¼�û���������Ľ�������ͬSessionId�¡������ǵ�¼�ɹ���ʱ�򣬿���ͨ��HTTP�����ȡ��Cookie��Ϣ�����а����Ự��SessionId��ͬʱҲ�����Լ���SessionId����Json�з��ء�Session���ǿ�����һ����̬��������ţ�ÿ������������������ʱ��SessionId����ȥ�����������Զ��������SessionId��û��ʧЧ��
	DefaultHttpClient httpclient = new DefaultHttpClient();
	HttpPost httpPost = new HttpPost(���ʵ�ַ);
	httpPost.setHeader("Cookie", "JSESSIONID=" + value�����ھ�̬�������ŵ�SessionId);
	HttpResponse httpResponse = httpclient.execute(httpPost);
	�����Ϳ��Խ�SessionId����ȥ�ˡ�
��ע������httpPost.setHeader("Cookie", "JSESSIONID=" + �����ھ�̬�������ŵ�SessionId);���е�JSESSIONID�������ȡ��	      cookieNameҲ������Ҫ������cookie���ƣ�value���Ƕ�Ӧ��cookieֵ
2����ȡcookie��Ϣ
	DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("");
        List<Cookie> alCookies = httpClient.getCookieStore().getCookies();
        if(!alCookies.isEmpty())
        {
        	for(int i =0;i<alCookies.size();i++)
            {
            	Cookie cookie = alCookies.get(i);
            	Log.i("tag", "==========================Name: "+cookie.getName());
            	Log.i("tag", "==========================value: "+cookie.getValue());
            	Log.i("tag", "==========================path: "+cookie.getPath());
            	Log.i("tag", "==========================domain: "+cookie.getDomain());
            	Log.i("tag", "==========================date: "+cookie.getExpiryDate());
            }
        }
        try {
		httpClient.execute(httpPost);
	} catch (ClientProtocolException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
����WebView��cookie��ͬ������
	1������cookie����һ���ڣ�onCreate()���ã�
		CookieSyncManager cookieManager = CookieSyncManager.createInstance(this); //cookie����
		//��ʼ��webViewͬ��
		cookieManager.startSync();
	2.����ͬ��������һ���ڣ�onResume()��onPause()��
		cookieManager.sync();
		cookieManager.stopSync();