package action;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport{
	private File[] uploadfile;
    private String[] uploadfileFileName;
    private String[] uploadfileContentType;
    private String goods_id;
    
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	public File[] getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(File[] uploadfile) {
		this.uploadfile = uploadfile;
	}
	public String[] getUploadfileFileName() {
		return uploadfileFileName;
	}
	public void setUploadfileFileName(String[] uploadfileFileName) {
		this.uploadfileFileName = uploadfileFileName;
	}
	public String[] getUploadfileContentType() {
		return uploadfileContentType;
	}
	public void setUploadfileContentType(String[] uploadfileContentType) {
		this.uploadfileContentType = uploadfileContentType;
	}
	
	public String execute() throws IOException {
		Map<String, Object> sesssion = ActionContext.getContext().getSession();
		System.out.println("halou liluo!");
		String realpath = ServletActionContext.getServletContext().getRealPath("/WebContent/image/"+
												ActionContext.getContext().getSession().get("seller_username")+"_shop/");
		//realpath = realpath.replaceAll(".metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\", "");
		String projectPath = getClass().getResource("/").getFile().toString();
		projectPath = realpath.replace(".metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\", "");
		//projectPath = projectPath+"WebContent\\";
		System.out.println(projectPath);
		File file = new File(projectPath);
		System.out.println(realpath);
		if (!file.exists()) {
			file.mkdirs();
		}
		System.out.println("halou liluo!222222");
		System.out.println(this.uploadfileFileName+"  666666666");
		//System.out.println(this.uploadfile.getName());
		for(int i=0;i<this.uploadfile.length;i++) {
			FileUtils.copyFile(this.uploadfile[i], new File(file, this.goods_id+".png"));
			
		}
		//FileUtils.copyFile(this.uploadfile, file);
		System.out.println("halou liluo!3333");

		return "success";

	}
}
