package ru.lubich.friendservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import ru.lubich.friendservice.repository.FriendRepository;
import ru.lubich.friendservice.model.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ru.lubich.friendservice.common.*;

import javax.validation.constraints.NotNull;

@Controller
public class FriendController {

    @Autowired
    private FriendRepository friendRepository;

    @RequestMapping(value = "/friends", method = RequestMethod.GET)
    public @ResponseBody Iterable<Friend> getAllFriends() {


        // This returns a JSON or XML with the users

        return friendRepository.findAll();
    }
    @RequestMapping(value = "/friends", method = RequestMethod.POST)
    public @ResponseBody CountsFriends postFriend(@RequestBody Friend postfriend) {


        postfriend.setStatus(0);
        Friend addfriend = new Friend(postfriend.getFriendid(),postfriend.getUserid(),postfriend.getStatus());

        friendRepository.save(postfriend);
        friendRepository.save(addfriend);
        // This returns a JSON or XML with the users

        CountsFriends countsFriends = new CountsFriends(friendRepository.countByUserid(postfriend.getUserid()),
                friendRepository.countOutRequestByUserid(postfriend.getUserid()),
                friendRepository.countInRequestByUserid(postfriend.getUserid()));

        return countsFriends;
    }

    @RequestMapping(value = "/friends/{userid}", method = RequestMethod.GET)
    public @ResponseBody CountsFriends getCountFriend(@PathVariable("userid") Integer userid) {


        CountsFriends countsFriends = new CountsFriends(friendRepository.countByUserid(userid),
                friendRepository.countOutRequestByUserid(userid),
                friendRepository.countInRequestByUserid(userid));

        return countsFriends;

    }

    @RequestMapping(value = "/friends/{userid}/accept/{friendid}", method = RequestMethod.GET)
    public @ResponseBody CountsFriends AcceptFriend(@PathVariable("userid") Integer userid, @PathVariable("friendid") Integer friendid) {


        friendRepository.AcceptFriend(userid,friendid);
        friendRepository.AcceptFriend(friendid, userid);

        CountsFriends countsFriends = new CountsFriends(friendRepository.countByUserid(userid),
                friendRepository.countOutRequestByUserid(userid),
                friendRepository.countInRequestByUserid(userid));

        return countsFriends;

    }

    @RequestMapping(value = "/friends/{userid}/friend/{friendid}", method = RequestMethod.DELETE)
    public @ResponseBody CountsFriends DeleteFriend(@PathVariable("userid") Integer userid,
                                               @PathVariable("friendid") Integer friendid) {

        //UserLike userlike = new UserLike(likeRepository.countByPost_Id(post_id), likeRepository.findByPost_Id(post_id));
        friendRepository.DeleteFriend(userid, friendid);
        friendRepository.DeleteFriend(friendid, userid);
        // This returns a JSON or XML with the users

        CountsFriends countsFriends = new CountsFriends(friendRepository.countByUserid(userid),
                friendRepository.countOutRequestByUserid(userid),
                friendRepository.countInRequestByUserid(userid));

        return countsFriends;
    }

    @RequestMapping(value = "/friends/{userid}/isfriend/{friendid}", method = RequestMethod.GET)
    public @ResponseBody isFriend getisFriended(@PathVariable("userid") Integer userid,
                                            @PathVariable("friendid") Integer friendid) {

        //UserLike userlike = new UserLike(likeRepository.countByPost_Id(post_id), likeRepository.findByPost_Id(post_id));
        //Iterable<Like> ListItems = new ArrayList<Like>();
        // This returns a JSON or XML with the users
        isFriend isfriend;
        if (friendRepository.countIsFriended(userid,friendid).intValue()>0)
        {
            isfriend = new isFriend(1);
        }
        else
        {
            isfriend = new isFriend(0);
        }
        return isfriend;
    }

    //Extended method
    // return list of friends id

//  public CountsFriendsExt getListFriends (Integer friendid)
//  {



//      return Null;
//  }


  @RequestMapping(value = "/friends/ext", method = RequestMethod.POST)
  public @ResponseBody CountsFriendsExt postFriendExt(@RequestBody Friend postfriend) {

      //Добавление в друзья с подтверждением
      //0 - с подтверждением, 1 - без подтверждения
      postfriend.setStatus(1);
      Friend addfriend = new Friend(postfriend.getFriendid(),postfriend.getUserid(),postfriend.getStatus());

      friendRepository.save(postfriend);
      friendRepository.save(addfriend);
      // This returns a JSON or XML with the users

      CountsFriendsFakeExt countsFriendsFakeExt = new CountsFriendsFakeExt(friendRepository.countByUserid(postfriend.getUserid()),
              friendRepository.countOutRequestByUserid(postfriend.getUserid()),
              friendRepository.countInRequestByUserid(postfriend.getUserid()),
              friendRepository.findByUserid(postfriend.getUserid()),
                      friendRepository.findByOutRequestByUserid(postfriend.getUserid()),
                      friendRepository.findByInRequestByUserid(postfriend.getUserid()));



      CountsFriendsExt countsFriendsExt = new CountsFriendsExt();
      countsFriendsExt.setFriendsCount(countsFriendsFakeExt.getFriendsCount());
      //Массив id - друзей
      ArrayList<Integer> uidStorage = new ArrayList<Integer>();
      uidStorage=(ArrayList)countsFriendsFakeExt.getFriend_id();

      //Хранилище профилей
      ArrayList<Profile> ProfileStorage = new ArrayList<Profile>();
      RestTemplate restTemplate = new RestTemplate();
      //
      ProfileRequestEntity profileRequestEntity;
      Profile profile = null;
      for (int i=0; i<uidStorage.size();i++)
      {
          try {
              profileRequestEntity = restTemplate.getForObject("http://ws-fpm.ru:5000/profile/"+uidStorage.get(i).toString(), ProfileRequestEntity.class);
              profile = new Profile();
              profile.setEmail(profileRequestEntity.getEmail());
              profile.setLogin(profileRequestEntity.getLogin());
              profile.setUid(profileRequestEntity.getUid());
              profile.setName(profileRequestEntity.getName());
              profile.setSurname(profileRequestEntity.getSurname());

              ProfileStorage.add(profile);



          } catch (HttpClientErrorException ex){

          }


      }

      countsFriendsExt.setFriend_id(ProfileStorage);


      return countsFriendsExt;

  }

    @RequestMapping(value = "/friends/{userid}/ext", method = RequestMethod.GET)
    //public @ResponseBody CountsFriendsExt getCountFriendExt(@PathVariable("userid") Integer userid) {
    public @ResponseBody CountsFriendsExt getCountFriendExt(@PathVariable("userid") Integer userid) {

        RequestProfile requestProfile = new RequestProfile(friendRepository.findByUserid(userid));
        //Create a Rest template
        RestTemplate restTemplate = new RestTemplate();

        //Create a list for the message converters

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();

        //Add the Jackson Message converter
         messageConverters.add(new MappingJackson2HttpMessageConverter());

        //Add the message converters to the restTemplate
         restTemplate.setMessageConverters(messageConverters);

        //The POST request.
        UsersProfileRequest usersProfileRequest = new UsersProfileRequest();
        CountsFriendsExt countsFriendsExt;

        try {
            usersProfileRequest = restTemplate.postForObject("http://ws-fpm.ru:5000/profile/search", requestProfile, UsersProfileRequest.class);
        }
                catch (HttpClientErrorException ex){

        }
        finally {

                            countsFriendsExt = new CountsFriendsExt(
                            friendRepository.countByUserid(userid),
                            friendRepository.countOutRequestByUserid(userid),
                            friendRepository.countInRequestByUserid(userid),
                            usersProfileRequest.getUsers(),
                            usersProfileRequest.getUsers(),
                            usersProfileRequest.getUsers()
                    );

        }

        return countsFriendsExt;
    }





 //@RequestMapping(value = "/friends/{userid}/accept/{friendid}/ext", method = RequestMethod.GET)
 //public @ResponseBody CountsFriendsExt AcceptFriendExt(@PathVariable("userid") Integer userid, @PathVariable("friendid") Integer friendid) {


 //    friendRepository.AcceptFriend(userid,friendid);
 //    friendRepository.AcceptFriend(friendid, userid);

 //    CountsFriendsExt countsFriendsExt = new CountsFriendsExt(friendRepository.countByUserid(userid),
 //            friendRepository.countOutRequestByUserid(userid),
 //            friendRepository.countInRequestByUserid(userid),
 //            friendRepository.findByUserid(userid),
 //            friendRepository.findByOutRequestByUserid(userid),
 //            friendRepository.findByInRequestByUserid(userid));


 //    return countsFriendsExt;

 //}

 @RequestMapping(value = "/friends/{userid}/friend/{friendid}/ext", method = RequestMethod.DELETE)
 public @ResponseBody CountsFriendsExt DeleteFriendExt(@PathVariable("userid") Integer userid,
                                                 @PathVariable("friendid") Integer friendid) {

     //UserLike userlike = new UserLike(likeRepository.countByPost_Id(post_id), likeRepository.findByPost_Id(post_id));
     friendRepository.DeleteFriend(userid, friendid);
     friendRepository.DeleteFriend(friendid, userid);
     // This returns a JSON or XML with the users

     //Вывод массива друзей
     CountsFriendsFakeExt countsFriendsFakeExt = new CountsFriendsFakeExt(friendRepository.countByUserid(userid),
             friendRepository.countOutRequestByUserid(userid),
             friendRepository.countInRequestByUserid(userid),
             friendRepository.findByUserid(userid),
             friendRepository.findByOutRequestByUserid(userid),
             friendRepository.findByInRequestByUserid(userid));

     CountsFriendsExt countsFriendsExt = new CountsFriendsExt();
     countsFriendsExt.setFriendsCount(countsFriendsFakeExt.getFriendsCount());
     //Массив id - друзей
     ArrayList<Integer> uidStorage = new ArrayList<Integer>();
     uidStorage=(ArrayList)countsFriendsFakeExt.getFriend_id();

     //Хранилище профилей
     ArrayList<Profile> ProfileStorage = new ArrayList<Profile>();
     RestTemplate restTemplate = new RestTemplate();
     //
     ProfileRequestEntity profileRequestEntity;
     Profile profile = null;
     for (int i=0; i<uidStorage.size();i++)
     {
         try {
             profileRequestEntity = restTemplate.getForObject("http://ws-fpm.ru:5000/profile/"+uidStorage.get(i).toString(), ProfileRequestEntity.class);
             profile = new Profile();
             profile.setEmail(profileRequestEntity.getEmail());
             profile.setLogin(profileRequestEntity.getLogin());
             profile.setUid(profileRequestEntity.getUid());
             profile.setName(profileRequestEntity.getName());
             profile.setSurname(profileRequestEntity.getSurname());

             ProfileStorage.add(profile);



         } catch (HttpClientErrorException ex){

         }


     }

     countsFriendsExt.setFriend_id(ProfileStorage);


     return countsFriendsExt;
 }


 //@RequestMapping(value = "/test", method = RequestMethod.GET)
 //public @ResponseBody Profile test() {




 //    //no email found. Connecting to Profile API GET /profile/cache?email=email@email.com
 //    RestTemplate restTemplate = new RestTemplate();
 //    ProfileRequestEntity profileRequestEntity;
 //    Profile profile = null;
 //    try {
 //        profileRequestEntity = restTemplate.getForObject("http://ws-fpm.ru:5000/profile/1", ProfileRequestEntity.class);

 //        profile = new Profile();
 //        profile.setEmail(profileRequestEntity.getEmail());
 //        profile.setLogin(profileRequestEntity.getLogin());
 //        profile.setUid(profileRequestEntity.getUid());




 //    } catch (HttpClientErrorException ex){

 //    }

 //    return profile;

 //}





}




