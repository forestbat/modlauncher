package cpw.mods.modlauncher;

import cpw.mods.modlauncher.api.ILaunchHandlerService;

/**
 * Decorates {@link ILaunchHandlerService} for use by the system
 */
public class LaunchServiceHandlerDecorator
{
    private final ILaunchHandlerService service;

    public LaunchServiceHandlerDecorator(ILaunchHandlerService service)
    {
        this.service = service;
    }

    public void launch(String[] arguments, ClassLoader classLoader)
    {
        try
        {
            this.service.launchService(arguments, classLoader).call();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}