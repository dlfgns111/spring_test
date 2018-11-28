package spring.model.bbs;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ReplyDAOTest {
	
	private static ReplyDAO dao;
	private static BeanFactory beans;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Resource resource = new ClassPathResource("daoTest.xml");
		beans = new XmlBeanFactory(resource);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dao = (ReplyDAO)beans.getBean("reply");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void testRcount() {
		int bbsno=3;
		int cnt = dao.rcount(bbsno);
		assertEquals(cnt,3);
	}

	@Test
	@Ignore
	public void testTotal() {
		int bbsno = 3;		
		int total = dao.total(bbsno);
		assertEquals(total,3);
	}

	@Test
	public void testBdelete() {
		int bbsno = 41;
		assertTrue(dao.bdelete(bbsno));
	}

	@Test
	public void testDelete() {
		int rnum=10;
		assertTrue(dao.delete(rnum));
	}

	@Test
	@Ignore
	public void testList() {
		Map map = new HashMap();
		map.put("bbsno", 3);
		map.put("sno", 1);
		map.put("eno", 10);
		List<ReplyDTO> list = dao.list(map );
		
		assertEquals(list.size(),3);
		
	}

	@Test
	@Ignore
	public void testUpdate() {
		int rnum = 5;
		ReplyDTO dto = dao.read(rnum);
		dto.setContent("내용변경");
		assertTrue(dao.update(dto));
	}

	@Test
	@Ignore
	public void testRead() {
		int rnum = 5;
		ReplyDTO dto = dao.read(rnum);
		assertNotNull(dto);
	}

	@Test
	@Ignore
	public void testCreate() {
		ReplyDTO dto = new ReplyDTO();
		dto.setContent("냇글내용 입니다.");
		dto.setId("bbb2");
		dto.setBbsno(40);
		assertTrue(dao.create(dto));
	}

}
