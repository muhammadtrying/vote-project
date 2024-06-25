package uz.muhammadtrying.voteproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.muhammadtrying.voteproject.dto.BloggerDTO;
import uz.muhammadtrying.voteproject.entity.Blogger;

import java.util.List;

public interface BloggerRepository extends JpaRepository<Blogger, Integer> {
    @Query(nativeQuery = true, value = """
            select b.id as id, b.name as name, count(c.id) as customers
            from blogger b
                     join public.customer c on b.id = c.blogger_id
            group by b.id;

            """)
    List<BloggerDTO> findAllWithCustomerNumber();
}