public class FamilyFactory implements Factory{//concrete factory for family creation
        @Override
        public Family create(String familyName){
            return new Family(familyName);
        }


}
