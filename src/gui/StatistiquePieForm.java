package gui;

import com.codename1.charts.views.BarChart;
import com.codename1.charts.views.BarChart.Type;
import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.models.XYMultipleSeriesDataset;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.renderers.XYMultipleSeriesRenderer;
import com.codename1.charts.renderers.XYMultipleSeriesRenderer.Orientation;
import com.codename1.charts.renderers.XYSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import entities.ContratSponsoring;
import utils.EnumEtatContrat;
import java.util.ArrayList;
import java.util.List;
import services.ServiceContratSponsoring;


public class StatistiquePieForm extends BaseForm {
    private boolean drawOnMutableImage;
    int idCurrentUserSponsor = 734;
   
    //get toutes les contrats d'un sponsor
    ArrayList<ContratSponsoring> contrats = ServiceContratSponsoring.getInstance().getAllContrats(idCurrentUserSponsor);

    
    private double nbr_feedback = 45;
    private double nbr_reclamation = 29;
    
    private double nbr_Proposition = 0;
    private double nbr_ContreProposition = 0;
    private double nbr_EnCours = 0;
    private double nbr_Expire = 0;
    
    
   
        Form current;
        BaseForm form;
        
        public StatistiquePieForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
        
        @Override
    protected boolean isCurrentStats() {
        return true;
    }
        public StatistiquePieForm(Resources res)  {
        //super("Newsfeed", BoxLayout.y());
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        
        
                getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Stats sur mes Contrats", "Title")//,
                        //new Label(" Statistiques Contrat", "InboxNumber")
                )
        );
                
        installSidemenu(res);

        getToolbar().addCommandToRightBar("", res.getImage("toolbar-profile-pic.png"), e -> {});

        
        Tabs swipe = new Tabs();

        Label spacer1 = new Label();
        Label spacer2 = new Label();
        Label spacer3 = new Label();
        Label spacer4 = new Label();
        
        swipe.setUIID("Container");
        swipe.getContentPane().setUIID("Container");
        swipe.hideTabs();
        
        ButtonGroup bg = new ButtonGroup();
        int size = Display.getInstance().convertToPixels(1);
        Image unselectedWalkthru = Image.createImage(size, size, 0);
        Graphics g = unselectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAlpha(100);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        Image selectedWalkthru = Image.createImage(size, size, 0);
        g = selectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        RadioButton[] rbs = new RadioButton[swipe.getTabCount()];
        FlowLayout flow = new FlowLayout(CENTER);
        flow.setValign(BOTTOM);

        //app 
        createPieChartForm();
        
        
        }
    
    
    
    
    
     private void updateArrowPosition(Button b, Label arrow) {
        arrow.getUnselectedStyle().setMargin(LEFT, b.getX() + b.getWidth() / 2 - arrow.getWidth() / 2);
        arrow.getParent().repaint();
        
        
    }
    
   private void addButton(Image img,String title) {
          int height = Display.getInstance().convertToPixels(11.5f);
        int width = Display.getInstance().convertToPixels(14f);
        Button image = new Button(img.fill(width, height));
        image.setUIID("Label");
        Container cnt = BorderLayout.west(image);
        cnt.setLeadComponent(image);
        TextArea ta = new TextArea(title);
        ta.setUIID("NewsTopLine");
        ta.setEditable(false);

  ;       
      
       cnt.add(BorderLayout.CENTER, 
               BoxLayout.encloseY(
                       ta
               ));
       
       image.addActionListener(e -> {
           try{
           //new AjoutReclamationForm(Resources.getGlobalResources()).show();
               System.out.println("click image");
           }catch(Exception exx) {
               
           }
               });
        add(cnt);
        image.addActionListener(e -> ToastBar.showMessage(title, FontImage.MATERIAL_INFO));
   }
    private void bindButtonSelection(Button b, Label arrow) {
        b.addActionListener(e -> {
            if(b.isSelected()) {
                updateArrowPosition(b, arrow);
            }
        });
    }
    

    //Statistique :
    //fontion : bch n7adhro size ta3 labels ta3 stat w margin w colors ba3d chn3aytoulha methode hethi.
    public DefaultRenderer buildCatRendrer(int []colors) {
        
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLabelsTextSize(15);
        renderer.setLegendTextSize(15);
        renderer.setMargins(new int[] {20, 30, 15, 0});
        
        for(int color : colors) {
            SimpleSeriesRenderer simpleSeriesRenderer = new SimpleSeriesRenderer();
            
            simpleSeriesRenderer.setColor(color);
            renderer.addSeriesRenderer(simpleSeriesRenderer);
        }
        return renderer;
     }  
    
    
    public void createPieChartForm() {
        
        for (ContratSponsoring contrat : contrats) {
            System.out.println(contrat);
        switch (contrat.getEtat().toString()) {
        case "Proposition":
            nbr_Proposition++;
            break;
        case "ContreProposition":
            nbr_ContreProposition++;
            break;
        case "EnCours":
            nbr_EnCours++;
            break;
        case "Expire":
            nbr_Expire++;
            break;
        }
        }
        System.out.println(nbr_Proposition + nbr_ContreProposition + nbr_EnCours + nbr_Expire);
        //chna3ml stat feedback par rapport l reclamation 
        double total = contrats.size();
        
        //values
        double prcntFeed = (nbr_Proposition *100)/total;
        
        double prcntRec = (nbr_ContreProposition * 100)/total;
        
        double prcntEnCours = (nbr_EnCours *100)/total;
        
        //colors set:
        int[]colors = new int[]{0xf4b342, 0x52b29a};
        
        DefaultRenderer renderer = buildCatRendrer(colors);
        renderer.setLabelsColor(0x000000); // black color for labels.
        
        renderer.setZoomButtonsVisible(true);//zoom
        renderer.setLabelsTextSize(40);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(20);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        r.setHighlighted(true);
        
        //CREATe the chart ...
        PieChart chart = new PieChart(buildDataset("title",Math.round(prcntFeed),Math.round(prcntRec)), renderer);
        
        // n7oto chart fi component
        ChartComponent c  = new ChartComponent(chart);
        
        String []messages = {
            "% Etat des contrat"
        };
        
        SpanLabel message = new SpanLabel(messages[0], "WelcomeMessage");
        
        Container cnt = BorderLayout.center(message);
        cnt.setUIID("Container");
        add(cnt);
        add(c);
                
                
    }

    private CategorySeries buildDataset(String title, double prcntFeed, double prcntRec) {
        
        CategorySeries series = new CategorySeries(title);
        
        series.add("Proposition",prcntRec);
        series.add("ContreProposition",prcntFeed);
        
        return series;
    }

}
