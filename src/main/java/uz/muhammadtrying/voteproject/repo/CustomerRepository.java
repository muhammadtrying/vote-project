package uz.muhammadtrying.voteproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.muhammadtrying.voteproject.dto.StatDTO;
import uz.muhammadtrying.voteproject.entity.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(nativeQuery = true, value = """
                    select c.id, c.name, c.phone, b.name as blogger, c.contacted
            from customer c
                     join public.blogger b on b.id = c.blogger_id;
            """)
    List<StatDTO> findAllWithBloggerId();
}