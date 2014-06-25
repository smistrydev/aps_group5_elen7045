package elen7045.group5.project.notify;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CreateXMLHeaderandFooterTest
{
	CreateXMLHeaderandFooter	test	= new CreateXMLHeaderandFooter();

	@Test
	public void testCreateXMLHeader()
	{
		assertEquals("<header>", test.createXMLHeader("header"));
	}

	@Test
	public void testCreateXMLFooter()
	{
		System.out.println(test.createXMLFooter("Norman"));
		assertEquals("<footer/>", test.createXMLFooter("footer"));
	}

	@Test
	public void testCreateXMLdata()
	{
		assertEquals("<data>", test.createXMLdata("data"));
	}

}
