package textmodifier.controller;

import org.apache.log4j.Logger;
import textmodifier.view.Constants;
import textmodifier.view.View;
import textmodifier.model.TextManager;
import textmodifier.utils.CustomScanner;
import textmodifier.utils.TextFileReader;

public class Controller {
    final static Logger logger = Logger.getLogger(Controller.class);
    private TextManager textManager;
    private View view;
    private CustomScanner scanner;

    public Controller(TextManager textManager, View view) {

        this.textManager = textManager;
        this.view = view;
        this.scanner = new CustomScanner(view);
    }

    public void run() {
        logger.info(Constants.LOG_RUN_STARTED);
        view.printMenu();
        String dir = inputDir();
        String filename = inputFileName(dir);
        while (!textManager.readDataFromFile(dir, filename)) {
            logger.error(Constants.LOG_CANT_READ_DATA);
            view.printData(Constants.FAIL_DOWNLOAD);
            dir = inputDir();
            filename = inputFileName(dir);
        }
        view.printData(Constants.INITIAL_TEXT);
        if (!textManager.createText()) {
            logger.error(Constants.LOG_FAIL_PARSE_DATA);
            view.printData(Constants.FAIL_DOWNLOAD);
        }
        logger.info(Constants.LOG_DATA_PARSED_FROM_FILE_DONE);
        view.printList(textManager.getSentenceList());
        view.printData("\n");
        view.printData(Constants.MODIFIED_TEXT);
        if (!textManager.modifyText()) {
            logger.error(Constants.LOG_FAIL_MODIFY_TEXT);
            view.printData(Constants.FAIL_DOWNLOAD);
        }
        logger.info(Constants.LOG_MODIFY_DONE);
        view.printList(textManager.getSentenceList());
        logger.info(Constants.LOG_RUN_COMPLETED);
    }

    private String inputDir() {
        view.printData(Constants.DIRECTORY);
        String dir = scanner.inputStringValueWithScanner();
        while (!TextFileReader.isDirectory(dir)) {
            logger.error(Constants.LOG_FAIL_DIR);
            view.printData(Constants.FAIL_DIRECTORY);
            dir = scanner.inputStringValueWithScanner();
        }
        logger.info(Constants.LOG_DIR_DONE);
        return dir;
    }

    private String inputFileName(String dir) {
        view.printData(Constants.FILE_NAME);
        String filename = scanner.inputStringValueWithScanner();
        while (!TextFileReader.isFileExist(dir, filename)) {
            logger.error(Constants.LOG_FILENAME_FAIL);
            view.printData(Constants.FAIL_FILENAME);
            filename = scanner.inputStringValueWithScanner();
        }
        logger.info(Constants.LOG_FILENAME_DONE);
        return filename;
    }
}
