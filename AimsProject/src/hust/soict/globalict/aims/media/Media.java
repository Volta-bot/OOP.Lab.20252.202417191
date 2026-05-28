package hust.soict.globalict.aims.media;
import java.util.Comparator;
public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	public Media(int id, String title, String category, float cost) {
		if (cost < 0) throw new IllegalArgumentException("ERROR: Cost cannot be negative");
		if (id < 0) throw new IllegalArgumentException("ERROR: ID cannot be negative");
		if (title == null || title.isBlank()) throw new IllegalArgumentException("ERROR: Title cannot be empty");
		
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(!(obj instanceof Media)) return false;

		Media other = (Media) obj;

		if(this.getTitle() == null) {
			return other.getTitle() == null;
		}

		return this.getTitle().equals(other.getTitle());
	}

}
