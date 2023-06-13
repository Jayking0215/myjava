package ex05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import weka.associations.Apriori;
import weka.associations.AssociationRule;
import weka.associations.AssociationRules;
import weka.associations.Item;
import weka.classifiers.Evaluation;
import weka.classifiers.rules.OneR;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SelectedTag;
import weka.core.converters.ConverterUtils.DataSource;

public class Weka07AprioriAssociation {
	
	String file="C:\\Weka-3-9\\data\\Book\\CharlesBookClub_preprocess.arff";
	DataSource ds;
	Instances data;
	Apriori model;//�������н�-�����м� ��
	
	public void loadArff(String file) throws Exception{
		ds=new DataSource(file);
		data=ds.getDataSet();
	}
	//������Ģ �˾Ƴ���
	public void association() throws Exception{
		model=new Apriori();
		model.setLowerBoundMinSupport(0.05);//������(Support) ����
		//��ü 4000�� �� 5%�̻� �ŷ��� �̷��� �����͸� ������� ����
		model.setMetricType(new SelectedTag(1, model.TAGS_SELECTION));
		//metricType�� ���(Lift)�� ���� (����Ʈ���� �ŷڵ�(Confidence))
		//�ŷڵ�:0, ���:1
		model.setMinMetric(1.5);
		//��� �ּҰ��� 1.5�� �����Ѵ�
		//A�� �������� B�� �Բ� ������ ������ 1.5�� �̻� ��Ÿ����
		model.setNumRules(10);
		//�н� ����
		model.buildAssociations(data);
		//evaluate�� �ʿ� ����, ������Ģ ������ �ؾ��Ѵ�
		AssociationRules rules=model.getAssociationRules();
		List<AssociationRule> rule_list=rules.getRules();
		printRule(rule_list);
		
		//�������� A�� �������� B���� �߻��� ��� �Ӽ����� �߻�Ƚ���� ����غ���
		Map<String, Integer> attrNameCounts=countByItemSets(rule_list);
		//System.out.println(attrNameCounts);
		
		//�������� �Ӽ��� �����ؼ� List�� ��ȯ�ϴ� �޼���
		List<String> attrNames=indexOfInstanceList(data);
		//System.out.println(attrNames);
		
		//�ִ� �߻��ϴ� �������� ���ϴ� �޼���
		int topIndex=fetchTopAttribute(attrNames, attrNameCounts);

		//OneR�з� �˰������� �ִ� �߻� �Ӽ��� �����Ӽ��� �������� Ȯ���غ���
		buildOneR(topIndex);
		
	}//----------------------------------------
	
	private void buildOneR(int topIndex) throws Exception {
		System.out.println("----OneR build---------------");
		data.setClassIndex(topIndex);
		System.out.println(data.classIndex()+", "+data.classAttribute());
		
		Instances train=data.trainCV(10, 0, new Random(1));
		Instances test=data.testCV(10, 0);
		
		Evaluation eval=new Evaluation(train);
		
		OneR model=new OneR();
		eval.crossValidateModel(model, train, 10, new Random(1));
		model.buildClassifier(train);//�н�
		eval.evaluateModel(model, test);
		System.out.println("�з���� ������ �Ǽ�: "+(int) eval.numInstances()+"��");
		System.out.println("���з� �Ǽ�: "+ (int)eval.correct()+"��");
		System.out.println("���з���: "+String.format("%.2f", eval.pctCorrect())+"%");
		System.out.println("----------------------------");
	}//----------------------------------------
	//�������� A�� �������� B���� �߻��� ��� �Ӽ����� �߻�Ƚ���� ����غ���
	private Map<String, Integer> countByItemSets(List<AssociationRule> rule_list) {
		Map<String, Integer> map=new HashMap<>();
		for(AssociationRule ar:rule_list) {
			Collection<Item> premise=ar.getPremise();
			//��������
			map=countByAttribute(premise, map);
			//��������
			Collection<Item> consequence=ar.getConsequence();
			map=countByAttribute(consequence,map);
		}
		return map;
	}//----------------------------------------
	
	private Map<String, Integer> countByAttribute(Collection<Item> itemSet, Map<String, Integer> map) {
		for(Item item:itemSet) {
			//�Ӽ��� ����
			String attrName=item.getAttribute().name();//�Ӽ���
			String yn=item.getItemValueAsString();//y,n �Ӽ���
			
			//�Ӽ��� �߻�ȸ�� ����
			if(map.get(attrName)==null) {
				map.put(attrName, 1);
			}else {
				Integer val=map.get(attrName);
				map.put(attrName, val+1);
			}
		}
		return map;
	}//----------------------------------------
	private List<String> indexOfInstanceList(Instances data) {
		List<String> attrNames=new ArrayList<>();
		Instance obj=data.firstInstance();
		for(int i=0;i<obj.numAttributes();i++) {
			Attribute attr=obj.attribute(i);
			attrNames.add(attr.name());
		}
		return attrNames;
	}//----------------------------------------
	private int fetchTopAttribute(List<String> attrNames, Map<String, Integer> attrNameCounts) {
		String topAttrName="";
		int topCount=0;
		int topIndex=0;
		
		for(int i=0;i<attrNames.size();i++) {
			String currAttrName=attrNames.get(i);
			if(currAttrName!=null) {
				Integer cnt=0;
				//System.out.println("currAttrName="+currAttrName);
				cnt=attrNameCounts.get(currAttrName);
				if(cnt==null) continue;
				if(cnt>topCount) {
					topCount=cnt;
					topAttrName=currAttrName;
					topIndex=i;
				}				
			}//if----			
		}//for-----------------
		System.out.println("�ִ� �߻� �Ӽ���: "+topAttrName+"="+topCount+", index: "+topIndex);
		
		return topIndex;
	}//----------------------------------------
	
	
	
	
	public void printRule(List<AssociationRule> rule_list) throws Exception{
		int i=1;
		for(AssociationRule ar:rule_list) {
			System.out.println("****"+i++ +"*************");
			System.out.println(ar);
			double[] metric=ar.getMetricValuesForRule();
			System.out.println("�ŷڵ�(Confidence): "+metric[0]);
			System.out.println("���(Lift)      : "+metric[1]);
			System.out.println("�������� A["+ar.getPremise()+"]�� ���� ������: "+ar.getPremiseSupport());
			System.out.println("�������� B["+ar.getConsequence()+"]�� ���� ������: "+ar.getTotalSupport());
			//premise +consequence
			System.out.println("��ü������: "+ar.getConsequenceSupport());
		}//for----
	}

	public static void main(String[] args) throws Exception{
		Weka07AprioriAssociation app=new Weka07AprioriAssociation();
		app.loadArff(app.file);
		app.association();

	}

}
