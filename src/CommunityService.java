public class CommunityService extends Service{

    public CommunityService(String serviceName) {
        super(serviceName);
    }

    public static boolean checkAllIntancesConstraints(Model model){
        Boolean isOk = true;
        for(Object object :model.allObjects) {
            if(object instanceof CommunityService){
                CommunityService communityService = (CommunityService)object;
                isOk = isOk && communityService.checkConstraints();
                if(!isOk)
                    return false;
            }
        }
        return true;
    }
}
