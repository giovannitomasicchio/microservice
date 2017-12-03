package it.giovannitomasicchio.microservice.repositories.jooq;

import static it.giovannitomasicchio.microservice.jooq.Tables.POST;
import static it.giovannitomasicchio.microservice.jooq.Tables.POST_DETAIL;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.giovannitomasicchio.microservice.dto.PostDTO;

@Repository
public class PostJooqRepository {

	@PersistenceContext
    private EntityManager em;
	
	@Autowired
	DSLContext create;
	
	public List<PostDTO> get(Long id) {
		
		Condition cond1 = DSL.trueCondition();
		
		if(id != null && id.longValue() != 0) {
			cond1 = cond1.and(POST.ID.eq(BigDecimal.valueOf(id)));
		}
		
		return create
				.selectFrom(POST
				.join(POST_DETAIL)
					.on(POST.ID.eq(POST_DETAIL.ID)))
				.where(
					cond1
				)
				.fetch()
				.into(PostDTO.class);
	}
	
}
