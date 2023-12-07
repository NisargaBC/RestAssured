package API_restAssured;

public class Pojo {
	
	private String name;
	private String job;
	
	public Pojo()
	{
		super();
	}

	public Pojo(String name, String job) {
		super();
		this.name = name;
		this.job = job;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getJob()
	{
		return job;
	}
	
	public void setJob(String job)
	{
		this.job = job;
	}
	
	
	

}
