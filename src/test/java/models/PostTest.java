package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class PostTest {

    @After
    public void tearDown() {
        Post.clearAllPosts();
    }

    public Post setupNewPost(){
        return new Post("Day 1: Intro");
    }

    @Test
    public void NewPostObjectGetsCorrectlyCreated_true() throws Exception {
        Post myPost = setupNewPost();
        assertEquals(true, myPost instanceof Post);
    }

    @Test
    public void PostInstantiatesWithContent_true() throws Exception {
        Post myPost = setupNewPost();
        assertEquals("Day 1: Intro", myPost.getContent());

    }

    @Test
    public void AllPostsAreCorrectlyReturned_true() {
        Post myPost = setupNewPost();
        Post otherPost = new Post ("How to pair successfully");
        assertEquals(2, Post.getAll().size());
    }

    @Test
    public void AllPostsContainsAllPosts_true() {
        Post myPost = setupNewPost();
        Post otherPost = new Post ("How to pair successfully");
        assertTrue(Post.getAll().contains(myPost));
        assertTrue(Post.getAll().contains(otherPost));
    }

    @Test
    public void getPublished_isFalseAfterInstantiation_false() throws Exception {
        Post myPost = new Post("Day 1: Intro");
        assertEquals(false, myPost.getPublished());
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() throws Exception{
        Post myPost = setupNewPost();
        assertEquals(LocalDateTime.now().getDayOfWeek(), myPost.getCreatedAt().getDayOfWeek());
    }

    @Test
    public void getId_postsInstantiateWithAnID_1() throws Exception{
        Post myPost = setupNewPost();
        assertEquals(1, myPost.getId());
    }

    @Test
    public void findReturnsCorrectPost() throws Exception {
        Post post = setupNewPost();
        assertEquals(1, Post.findById(post.getId()).getId());
    }

    @Test
    public void findReturnsCorrectPostWhenMoreThanOnePostExists() throws Exception {
        Post post = setupNewPost();
        Post otherPost = new Post("How to pair successfully");
        assertEquals(2, Post.findById(otherPost.getId()).getId());
    }
}