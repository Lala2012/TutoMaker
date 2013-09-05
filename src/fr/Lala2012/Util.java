package fr.Lala2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;

public class Util {

	public static String bbcode(String text) {
		String html = text.replace("\n".toString(), "<br />");

		Map<String, String> bbMap = new HashMap<String, String>();

		bbMap.put("(\r\n|\r|\n|\n\r)", "<br/>");
		bbMap.put("\\[b\\](.+?)\\[/b\\]", "<strong>$1</strong>");
		bbMap.put("\\[i\\](.+?)\\[/i\\]",
				"<span style='font-style:italic;'>$1</span>");
		bbMap.put("\\[u\\](.+?)\\[/u\\]",
				"<span style='text-decoration:underline;'>$1</span>");
		bbMap.put("\\[h1\\](.+?)\\[/h1\\]", "<h1>$1</h1>");
		bbMap.put("\\[h2\\](.+?)\\[/h2\\]", "<h2>$1</h2>");
		bbMap.put("\\[h3\\](.+?)\\[/h3\\]", "<h3>$1</h3>");
		bbMap.put("\\[h4\\](.+?)\\[/h4\\]", "<h4>$1</h4>");
		bbMap.put("\\[h5\\](.+?)\\[/h5\\]", "<h5>$1</h5>");
		bbMap.put("\\[h6\\](.+?)\\[/h6\\]", "<h6>$1</h6>");
		bbMap.put("\\[quote\\](.+?)\\[/quote\\]", "<blockquote>$1</blockquote>");
		bbMap.put("\\[p\\](.+?)\\[/p\\]", "<p>$1</p>");
		bbMap.put("\\[p=(.+?),(.+?)\\](.+?)\\[/p\\]",
				"<p style='text-indent:$1px;line-height:$2%;'>$3</p>");
		bbMap.put("\\[center\\](.+?)\\[/center\\]", "<div align='center'>$1");
		bbMap.put("\\[align=(.+?)\\](.+?)\\[/align\\]", "<div align='$1'>$2");
		bbMap.put("\\[color=(.+?)\\](.+?)\\[/color\\]",
				"<span style='color:$1;'>$2</span>");
		bbMap.put("\\[size=(.+?)\\](.+?)\\[/size\\]",
				"<span style='font-size:$1;'>$2</span>");
		bbMap.put("\\[img\\](.+?)\\[/img\\]", "<img src='$1' />");
		bbMap.put("\\[img=(.+?),(.+?)\\](.+?)\\[/img\\]",
				"<img width='$1' height='$2' src='$3' />");
		bbMap.put("\\[email\\](.+?)\\[/email\\]", "<a href='mailto:$1'>$1</a>");
		bbMap.put("\\[email=(.+?)\\](.+?)\\[/email\\]",
				"<a href='mailto:$1'>$2</a>");
		bbMap.put("\\[url\\](.+?)\\[/url\\]", "<a href='$1'>$1</a>");
		bbMap.put("\\[url=(.+?)\\](.+?)\\[/url\\]", "<a href='$1'>$2</a>");
		bbMap.put(
				"\\[youtube\\](.+?)\\[/youtube\\]",
				"<object width='640' height='380'><param name='movie' value='http://www.youtube.com/v/$1'></param><embed src='http://www.youtube.com/v/$1' type='application/x-shockwave-flash' width='640' height='380'></embed></object>");
		bbMap.put("\\[video\\](.+?)\\[/video\\]", "<video src='$1' />");
		bbMap.put("\\[code\\](.+?)\\[/code\\]",
				"<pre class=\"prettyprint lang-auto linenums:0\">$1</pre>");

		for (Map.Entry entry : bbMap.entrySet()) {
			html = html.replaceAll(entry.getKey().toString(), entry.getValue()
					.toString());
		}

		return html;
	}

	public static void performChangeSelectedText(int startSelection, int endSelection,
			Tag type) {

		String startStr = TutoMaker.mainFrame.getRedacText().substring(0,
				startSelection);
		String endStr = TutoMaker.mainFrame.getRedacText().substring(
				endSelection, TutoMaker.mainFrame.getRedacText().length());
		String selected = (TutoMaker.mainFrame.getRedacText().length() > 0) ? TutoMaker.mainFrame.getRedacText() : "";

		switch (type) {
		case COLOR:
			return;
		case BOLD:
			TutoMaker.mainFrame.setRedacText(startStr + "[b]" + selected
					+ "[/b]" + endStr);
			break;
		case ITALIC:
			TutoMaker.mainFrame.setRedacText(startStr + "[i]" + selected
					+ "[/i]" + endStr);
			break;
		case UNDERLINE:
			TutoMaker.mainFrame.setRedacText(startStr + "[u]" + selected
					+ "[/u]" + endStr);
			break;
		case HEADER1:
			TutoMaker.mainFrame.setRedacText(startStr + "[h1]" + selected
					+ "[/h1]" + endStr);
			break;
		case HEADER2:
			TutoMaker.mainFrame.setRedacText(startStr + "[h2]" + selected
					+ "[/h2]" + endStr);
			break;
		case HEADER3:
			TutoMaker.mainFrame.setRedacText(startStr + "[h3]" + selected
					+ "[/h3]" + endStr);
			break;
		case HEADER4:
			TutoMaker.mainFrame.setRedacText(startStr + "[h4]" + selected
					+ "[/h4]" + endStr);
			break;
		case HEADER5:
			TutoMaker.mainFrame.setRedacText(startStr + "[h5]" + selected
					+ "[/h5]" + endStr);
			break;
		case HEADER6:
			TutoMaker.mainFrame.setRedacText(startStr + "[h6]" + selected
					+ "[/h6]" + endStr);
			break;
		case QUOTE:
			TutoMaker.mainFrame.setRedacText(startStr + "[quote]" + selected
					+ "[/quote]" + endStr);
			break;
		case PARAGRAPH:
			TutoMaker.mainFrame.setRedacText(startStr + "[p]" + selected
					+ "[/p]" + endStr);
			break;
		case CENTER:
			TutoMaker.mainFrame.setRedacText(startStr + "[center]" + selected
					+ "[/center]" + endStr);
			break;
		case SIZE:
			return;
		case IMG:
			return;
		case EMAIL:
			TutoMaker.mainFrame.setRedacText(startStr + "[email]" + selected
					+ "[/email]" + endStr);
			break;
		case URL:
			return;
		case YOUTUBE:
			TutoMaker.mainFrame.setRedacText(startStr + "[youtube]" + selected
					+ "[/youtube]" + endStr);
			break;
		case VIDEO:
			TutoMaker.mainFrame.setRedacText(startStr + "[video]" + selected
					+ "[/video]" + endStr);
			break;
		case CODE:
			TutoMaker.mainFrame.setRedacText(startStr + "[code]" + selected
					+ "[/code]" + endStr);
			break;
		default:
			return;
		}

	}
	
	
	public static void performColor(int startSelection, int endSelection, String color) {

		String startStr = TutoMaker.mainFrame.getRedacText().substring(0,
				startSelection);
		String endStr = TutoMaker.mainFrame.getRedacText().substring(
				endSelection, TutoMaker.mainFrame.getRedacText().length());
		String selected = (TutoMaker.mainFrame.getRedacText().length() > 0) ? TutoMaker.mainFrame.getRedacText() : "";

		TutoMaker.mainFrame.setRedacText(startStr + "[color=" + color + "]" + selected
					+ "[/color]" + endStr);


	}
	
	public static void performSize(int startSelection, int endSelection, int size) {

		String startStr = TutoMaker.mainFrame.getRedacText().substring(0,
				startSelection);
		String endStr = TutoMaker.mainFrame.getRedacText().substring(
				endSelection, TutoMaker.mainFrame.getRedacText().length());
		String selected = (TutoMaker.mainFrame.getRedacText().length() > 0) ? TutoMaker.mainFrame.getRedacText() : "";

		TutoMaker.mainFrame.setRedacText(startStr + "[size=" + size + "]" + selected
					+ "[/size]" + endStr);


	}
	
	public static void performImage(int startSelection, int endSelection, String url) {

		String startStr = TutoMaker.mainFrame.getRedacText().substring(0,
				startSelection);
		String endStr = TutoMaker.mainFrame.getRedacText().substring(
				endSelection, TutoMaker.mainFrame.getRedacText().length());
		String selected = (TutoMaker.mainFrame.getRedacText().length() > 0) ? TutoMaker.mainFrame.getRedacText() : "";

		TutoMaker.mainFrame.setRedacText(startStr + "[img]" + url + selected
					+ "[/img]" + endStr);


	}

	
	
	public static void performUrl(int startSelection, int endSelection, String url) {

		String startStr = TutoMaker.mainFrame.getRedacText().substring(0,
				startSelection);
		String endStr = TutoMaker.mainFrame.getRedacText().substring(
				endSelection, TutoMaker.mainFrame.getRedacText().length());
		String selected = (TutoMaker.mainFrame.getRedacText().length() > 0) ? TutoMaker.mainFrame.getRedacText() : "";

		TutoMaker.mainFrame.setRedacText(startStr + "[url]" + url + selected
					+ "[/url]" + endStr);


	}

	public static void openFile() {

		JFileChooser chooser = new JFileChooser();
	
		int returnVal = chooser.showOpenDialog(TutoMaker.mainFrame
				.getContentPane());

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			BufferedReader br = null;
			String fileContent = null;
			try {

				String sCurrentLine;

				br = new BufferedReader(new FileReader(chooser
						.getSelectedFile().getAbsolutePath()));

				while ((sCurrentLine = br.readLine()) != null) {
					if (fileContent != null) {
						fileContent += sCurrentLine;
					} else {
						fileContent = sCurrentLine;
					}

				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null)
						br.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}

			TutoMaker.mainFrame.setRedacText(fileContent);
			TutoMaker.currentFileIsSaved = true;
			TutoMaker.currentFilePath = chooser.getSelectedFile()
					.getAbsolutePath();

		}

	}

	public static void saveInNewFile() {

		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Enregistrer");
		int returnVal = chooser.showOpenDialog(TutoMaker.mainFrame
				.getContentPane());

		System.out.println(chooser.getCurrentDirectory().getAbsolutePath());

		if (returnVal == JFileChooser.APPROVE_OPTION) {

			File newFile = new File(chooser.getSelectedFile().getAbsolutePath());
			try {
				newFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			writeFile(newFile.getAbsolutePath(),
					TutoMaker.mainFrame.getRedacText());

			TutoMaker.currentFileIsSaved = true;
			TutoMaker.currentFilePath = chooser.getSelectedFile()
					.getAbsolutePath();
		}
	}
	
	public static void saveInCurrentFile()
	{
		if (!TutoMaker.currentFileIsSaved)
		{
			saveInNewFile();
			return;
		}
		
		writeFile(TutoMaker.currentFilePath, TutoMaker.mainFrame.getRedacText());
		
		
	}

	public static void writeFile(String filename, String text) {
		try {
			// Create file
			FileWriter fstream = new FileWriter(filename);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(text);
			// Close the output stream
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static void close(Closeable closeable) {
		try {
			closeable.close();
		} catch (IOException ignored) {
		}
	}

}
