package com.constants;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Constant {


	public static Path currentRelativePath = Paths.get("");

	public static final String Path_TestData = currentRelativePath.toAbsolutePath().toString() + File.separator
			+ "TestData" + File.separator;

	public static final String File_TestData = "testdata.xlsx";
	public static final String Page_Url ="https://www.bhartiaxa.com/";

}
