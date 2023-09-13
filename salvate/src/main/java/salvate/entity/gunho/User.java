package salvate.entity.gunho;

import javax.persistence.Entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Entity
public class User {
	private String user_id, user_pw, firstname ,lastname ,create_ymd ,update_ymd;
}
