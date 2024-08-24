package Good_Night_3rd_Hackathon_Backend.Techeer_Tree.repository;

import Good_Night_3rd_Hackathon_Backend.Techeer_Tree.domain.Wishes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface WishesRepository extends JpaRepository<Wishes, Long> {

    @Query("SELECT wish FROM Wishes wish WHERE (:status IS NULL OR wish.isConfirm = :status)")
    Page<Wishes> getWishList(Wishes.WishesStatus status, Pageable pageable);
}