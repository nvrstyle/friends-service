package ru.lubich.friendservice.repository;

/**
 * Created by Евгений on 21.06.2017.
 */
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.lubich.friendservice.model.Friend;

import java.math.BigInteger;
import java.util.List;


public interface FriendRepository extends CrudRepository<Friend, Long> {
    @Query(value = "SELECT count(friendid) FROM friends WHERE userid = ?1 and status > 0",
            countQuery = "SELECT count(friendid) FROM friends WHERE userid = ?1 and status > 0",

            nativeQuery = true)
    BigInteger countByUserid(Integer post_id);

    @Query(value = "SELECT count(userid) FROM friends WHERE friendid = ?1 and status = 0",
            countQuery = "SELECT count(userid) FROM friends WHERE friendid = ?1 and status = 0",

            nativeQuery = true)
    BigInteger countInRequestByUserid(Integer post_id);

    @Query(value = "SELECT count(friendid) FROM friends WHERE userid = ?1 and status = 0",
            countQuery = "SELECT count(friendid) FROM friends WHERE userid = ?1 and status = 0",

            nativeQuery = true)
    BigInteger countOutRequestByUserid(Integer post_id);


    @Query(value = "SELECT user_id FROM likes WHERE post_id = ?1",
            nativeQuery = true)
    Iterable<Integer> findByPost_Id(Integer post_id);

    @Query(value = "SELECT count(userid) FROM friends WHERE userid = ?1 AND friendid = ?2 and status > 0",
            countQuery = "SELECT count(userid) FROM friends WHERE userid = ?1 AND friendid = ?2 and status > 0",
            nativeQuery = true)
    BigInteger countIsFriended(Integer userid, Integer friendid);

    @Modifying
    @Transactional
    @Query(value = "UPDATE friends SET status = 1 WHERE userid = ?1 AND friendid = ?2 and status = 0", nativeQuery = true)
    void AcceptFriend(Integer userid, Integer friendid);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM friends WHERE userid = ?1 AND friendid = ?2", nativeQuery = true)
    void DeleteFriend(Integer userid, Integer friendid);

    @Query(value = "SELECT friendid FROM friends WHERE userid = ?1 AND status > 0",
            nativeQuery = true)
    Iterable<Integer> findByUserid(Integer userid);

    @Query(value = "SELECT userid FROM friends WHERE friendid = ?1 AND status = 0",
            nativeQuery = true)
    Iterable<Integer> findByInRequestByUserid(Integer userid);

    @Query(value = "SELECT friendid FROM friends WHERE userid = ?1 AND status = 0",
            nativeQuery = true)
    Iterable<Integer> findByOutRequestByUserid(Integer userid);


}
