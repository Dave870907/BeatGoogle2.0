package test;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestProject
 */
@WebServlet("/TestProject")
public class TestProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if(request.getParameter("keyword")== null) {
			String requestUri = request.getRequestURI();
			request.setAttribute("requestUri", requestUri);
			request.getRequestDispatcher("Search.jsp").forward(request, response);
			return;
		}
		GoogleQuery google = new GoogleQuery(request.getParameter("keyword"));
		List<WebPage> infoIds  = new ArrayList<WebPage>();
		HashMap<String, String> result = google.query();
		
		Set r = result.keySet();
		Map<String, String> beforesort = new HashMap<String, String>();
		

		Iterator iterator = r.iterator();
		while (iterator.hasNext()) {
			ArrayList<String> vList = new ArrayList<String>();
			String key = iterator.next().toString();
			String value = result.get(key);
			beforesort.put(value, key);
			
			vList.add(value);

			// String aString = sc.nextLine();
			for (int i = 0; i < vList.size(); i++) {
				htmlContent h = new htmlContent(vList.get(i));
				int wordcount = h.countKeyword(request.getParameter("keyword"));// 算關鍵字在網頁中的數量
				// 获得html文本内容
				String HTML=null;
				List imgUrl=null;
				int imgcount=0;
				int initialTotal=0;
				try {
					HTML = h.getHtml();
				
				// 获取图片标签
				 imgUrl = h.getImageUrl(HTML);
				// 获取图片src地址
				 imgcount = h.getImageSrc(imgUrl); // 算圖片個數

				 initialTotal = imgcount * 200 + wordcount * 1;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				for (int p = 0; p < vList.size(); p++) {
					// WebPage a1 = new WebPage("https://www.google.com/search?q=" + keyword +
					// "&oe=utf8&num=25");

					// WebTree.root.webPage.score = initialTotal;
					// System.out.println(value);

					WebTree tree = new WebTree(new WebPage(vList.get(p)));
					List<String> children = (List<String>) htmlContent.workurl(tree.root.webPage.url, 2);
					for (int a = 0; a < 5; a++) {

						try {
							String child = children.get(a);
							tree.root.addChild(new WebNode(new WebPage(child)));
							htmlContent h1 = new htmlContent(child);
							int wordcount1 = h1.countKeyword(request.getParameter("keyword"));// 算關鍵字在網頁中的數量
							// 获得html文本内容
							String HTML1 = h1.getHtml();
							// 获取图片标签
							List imgUrl1 = h1.getImageUrl(HTML);
							// 获取图片src地址
							int imgcount1 = h1.getImageSrc(imgUrl); // 算圖片個數

							int total = imgcount1 * 200 + wordcount1 * 1;

							tree.root.children.get(a).webPage.score = total;

							initialTotal = initialTotal + total;

							tree.root.webPage.score = initialTotal;
							tree.root.children.get(a).webPage.score = total;

							String link = "(母網頁：" + tree.root.getlink() + "        分數：" + initialTotal;
							String sublink = "            (子網頁：" + tree.root.children.get(a).getlink()
									+ "        分數：" + total;
							String links = link + "\n" + sublink;
							String number = " ";
							System.out.println(links);
							//Map<String, Integer> beforesort = new HashMap<String, Integer>();
							String title = beforesort.get(tree.root.webPage.url);
							tree.root.webPage.name = title;
							infoIds.add(tree.root.webPage);
							
							// System.out.println(infoIds);
							// 对HashMap中的key 进行排序
							
							// 对HashMap中的key 进行排序后 显示排序结果
//							for (int b = 0; b < infoIds.size(); b++) {
//								String id = infoIds.get(b).toString();
								
								

							break;
						} catch (Exception e) {
//							e.printStackTrace();
//							break;
						}
						// System.out.println(allresult);

					}

				}
			}}
			
			Collections.sort(infoIds, new Comparator<WebPage>() {
				@Override
				public int compare(WebPage o1, WebPage o2) {
					// TODO Auto-generated method stub
					if(o1.score > o2.score)
						return 1;
					else if(o1.score < o2.score)
						return -1;
					else return 0;
				}
			});
		
		String[][] s = new String[result.size()][2];
		request.setAttribute("query", infoIds);
//		int num = 0;
//		for(Entry<String, String> entry : result.entrySet()) {
//		    String key = entry.getKey();
//		    String value = entry.getValue();
//		    s[num][0] = key;
//		    s[num][1] = value;
//		    num++;
//		}
		request.getRequestDispatcher("googleitem.jsp")
		 .forward(request, response); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}