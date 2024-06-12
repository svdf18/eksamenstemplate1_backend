package kea3.eksamenstemplate1_backend.template;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long>{
    Item findByName(String name);
}
