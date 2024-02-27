package ThaiGongProject.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="online_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OnlineOrder {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private LocalUser user;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "address_id", nullable = false)
	private LocalUser address;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<OnlineOrderDetail> quantities = new ArrayList<>();
	
	@Column(name = "submited_date", nullable = false)
	private Date submitedDate;
	
	
}
