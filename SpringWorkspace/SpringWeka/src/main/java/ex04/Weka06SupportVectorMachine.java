package ex04;

import java.util.Arrays;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.SMO;
import weka.core.Attribute;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Normalize;

//functions/SMO==>SupportVectorMachine 알고리즘
//==>(데이터가 정규화 또는 표준화 되어있어야함)
public class Weka06SupportVectorMachine {
	
	String file="C:\\Weka-3-9\\data\\Titanic\\titanic_ko_java.arff";
	Instances data, train, test;
	SMO model;
	
	public void loadArff(String file) throws Exception{
		data=new DataSource(file).getDataSet();
		data.randomize(new Random(1));
		//정규화 진행하기(Normalize)
		Normalize norm=new Normalize();
		norm.setInputFormat(data);
		Instances newData=Filter.useFilter(data, norm);
		
		train=newData.trainCV(10,0,new Random(1));
		test=newData.testCV(10, 0);
		
		//정답데이터 지정
//		train.setClassIndex(1);// 2번째 속성(Survived)을 정답데이터로 지정하는 경우
		train.setClassIndex(1);
		test.setClassIndex(1);
		
	}//-------------------------------------
	public void generateModel_Evaluate() throws Exception{
		Evaluation eval=new Evaluation(train);
		model=new SMO();
		eval.crossValidateModel(model, train, 10, new Random(1));
		System.out.println("--SMO model run before-----------");
		//학습 진행
		model.buildClassifier(train);
		System.out.println("--SMO model run after-----------");
		
		//검증
		eval.evaluateModel(model, test);
		System.out.println("-----------------------");
		System.err.printf("전체 데이터 건수: %d%n",(int)eval.numInstances());
		System.out.printf("정 분류 건수: %d개%n",(int)eval.correct());
		System.out.println("정분류율: "+String.format("%,2f", eval.pctCorrect())+"%");
		System.out.println("-----------------------");
		System.out.println(eval.toSummaryString());
	}//-------------------------------------
	public void predictOne(String pclass,double age, String sex) throws Exception{
											//속성명, List<String> => 속성값리스트, index
		Attribute attrPclass=new Attribute("pclass", Arrays.asList("1등급","2등급","3등급"),0);
		Attribute attrSurvived=new Attribute("survived",Arrays.asList("사망","생존"),1);
		Attribute attrSex=new Attribute("sex",Arrays.asList("여성","남성"),2);
		Attribute attrAge=new Attribute("age",Arrays.asList(String.valueOf(age)),3);
		
	}//-------------------------------------
	
	public static void main(String[] args) throws Exception{
		Weka06SupportVectorMachine app=new Weka06SupportVectorMachine();
		app.loadArff(app.file);
		app.generateModel_Evaluate();
	}//-------------------------------------

}
