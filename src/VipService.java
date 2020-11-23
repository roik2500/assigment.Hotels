public class VipService extends Service{

    public VipService(String serviceName) {
        super(serviceName);
    }

    public static boolean checkAllIntancesConstraints(Model model){
        Boolean isOk = true;
        for(Object object :model.allObjects) {
            if(object instanceof VipService){
                VipService vipService = (VipService)object;
                isOk = isOk && vipService.checkConstraints();
                if(!isOk)
                    return false;
            }
        }
        return true;
    }

}
