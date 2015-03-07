/**
 * 
 * @author michael
 *
 */
public class Picture 
{

	private String artist;
	private String title;
	private float purPrice; //purchase price
	private boolean rare;
	private boolean alreadySet; //for setArtist
	
	/*public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Picture p =new Picture();
		System.out.println(p.toString());
	}*/
	
	

	/**
	 * @param artist
	 * @param title
	 * @param purPrice
	 * @param rare
	 */
	public Picture(String artist, String title, float purPrice, boolean rare) throws ExceptionForgotAttribute
	{
		super();
		this.setArtist(artist);
		this.setTitle(title);
		this.setPurPrice(purPrice);
		this.setRare(rare);
	}

	


	/**
	 * 
	 */
	public Picture() throws ExceptionForgotAttribute
	{
		super();
		this.setArtist("Van Gogh");
		this.setTitle("Scream");
		this.setPurPrice(5000);
		this.setRare(true);
	}



	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) throws ExceptionForgotAttribute
	{
		if (alreadySet==true) System.err.println("Artist is already set!");
		if (artist==null || artist=="") throw new ExceptionForgotAttribute ("Artist not set.");
		else
		{
			this.artist = artist;
			alreadySet=true;
		}
	}

	/**
	 * @return the title
	 */
	public String getTitle() 
	{
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) throws ExceptionForgotAttribute
	{
		if (title==null || title == "") throw new ExceptionForgotAttribute("Title not set.");
		this.title = title;
	}

	/**
	 * @return the purPrice
	 */
	public float getPurPrice() {
		return purPrice;
	}

	/**
	 * @param purPrice the purPrice to set
	 */
	public void setPurPrice(float purPrice) throws ExceptionForgotAttribute
	{
		if (purPrice<=0) throw new ExceptionForgotAttribute("Purchase price not set.");
		this.purPrice = purPrice;
	}

	/**
	 * @return the rare
	 */
	public boolean isRare() {
		return rare;
	}

	/**
	 * @param rare the rare to set
	 */
	public void setRare(boolean rare)
	{
		this.rare = rare;
	}

	public float calculateRetailPrice()
	{
		if (isRare())
		{
			return purPrice *2;
		}
		else {
			return purPrice *1.25f;
		}
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Picture [artist=" + artist + ", title=" + title + ", retail price="
				+ calculateRetailPrice() + ", rare=" + rare + "]";
	}
	
	
	
	
}
