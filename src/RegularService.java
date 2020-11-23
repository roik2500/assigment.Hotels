public class RegularService extends Service {


    public RegularService(String serviceName) {
        super(serviceName);
    }

    public static boolean checkAllIntancesConstraints(Model model){
        Boolean isOk = true;
        for(Object object :model.allObjects) {
            if(object instanceof RegularService){
                RegularService regularService = (RegularService)object;
                isOk = isOk && regularService.checkConstraints();
                if(!isOk)
                    return false;
            }
        }
        return true;
    }
}
