package uz.muhammadtrying.voteproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.muhammadtrying.voteproject.dto.BloggerDTO;
import uz.muhammadtrying.voteproject.dto.ResponseDTO;
import uz.muhammadtrying.voteproject.dto.StatDTO;
import uz.muhammadtrying.voteproject.entity.Blogger;
import uz.muhammadtrying.voteproject.entity.Customer;
import uz.muhammadtrying.voteproject.repo.BloggerRepository;
import uz.muhammadtrying.voteproject.repo.CustomerRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PageController {
    private final BloggerRepository bloggerRepository;
    private final CustomerRepository customerRepository;

    @GetMapping("/get/bloggers")
    public List<BloggerDTO> getBloggers() {
        return bloggerRepository.findAllWithCustomerNumber();
    }

    @PostMapping("/add/vote")
    public void addVote(@RequestBody ResponseDTO responseDTO) {
        Blogger blogger = bloggerRepository.findById(responseDTO.getBloggerId()).get();
        Customer customer = Customer.builder()
                .name(responseDTO.getName())
                .phone(responseDTO.getName())
                .blogger(blogger)
                .build();
        customerRepository.save(customer);
    }

    @GetMapping("/get/statistics")
    public List<StatDTO> getStats() {
        return customerRepository.findAllWithBloggerId();
    }

    @PostMapping("/alter/contacted/{customerId}")
    public void alterContacted(@PathVariable Integer customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        customer.setContacted(true);
        customerRepository.save(customer);
    }
}
